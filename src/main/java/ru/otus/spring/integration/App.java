package ru.otus.spring.integration;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.scheduling.PollerMetadata;
import ru.otus.spring.integration.domain.Pensioner;
import ru.otus.spring.integration.domain.Person;
import ru.otus.spring.integration.life.filters.CompanyFilter;
import ru.otus.spring.integration.life.filters.UniversityFilter;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;


@Log
@IntegrationComponentScan
@SuppressWarnings({ "resource", "Duplicates", "InfiniteLoopStatement" })
@ComponentScan
@Configuration
@EnableIntegration
public class App {

    private static List<Person> personList = List.of(
            Person.builder().FIO("Ivanov Ivan").age(7).build(),
            Person.builder().FIO("Smirnov Smirno").age(8).build(),
            Person.builder().FIO("Petrov Petro").age(6).build());

    @Autowired
    UniversityFilter universityFilter;

    @Autowired
    CompanyFilter companyFilter;

    @Bean
    public QueueChannel personChannel() {
        return MessageChannels.queue( 10 ).get();
    }

    @Bean
    public QueueChannel schoolEndChanel() {
        return MessageChannels.queue( 10 ).get();
    }

    @Bean
    public QueueChannel universityEndChanel() {
        return MessageChannels.queue( 10 ).get();
    }

    @Bean
    public QueueChannel companyEndChanel() {
        return MessageChannels.queue( 10 ).get();
    }

    @Bean
    public QueueChannel socialChanel() {
        return MessageChannels.queue( 10 ).get();
    }

    @Bean
    public QueueChannel lifeEndChanel() {
        return MessageChannels.queue( 10 ).get();
    }

    @Bean
    public PublishSubscribeChannel pensionerChannel() {
        return MessageChannels.publishSubscribe().get();
    }

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        return Pollers.fixedRate( 100 ).maxMessagesPerPoll( 2 ).get();
    }

    @Bean
    public IntegrationFlow lifeFlow() {
        return IntegrationFlows.from("personChannel")
                .split()
                .handle("schoolService", "process")
                .channel("schoolEndChanel")
                .filter(universityFilter::filterSchoolboys,
                        notUniverse -> notUniverse.discardChannel("socialChanel"))
                .handle("universityService", "process")
                .channel("universityEndChanel")
                .filter(companyFilter::filterUniversityBoys,
                        notCompany -> notCompany
                                .discardFlow(df -> df
                                        .channel("socialChanel")
                                        .handle("socialService", "process")
                                        .aggregate()
                                        .channel("pensionerChannel"))

                )
                .handle("companyService", "process")
                .channel("companyEndChanel")
                .handle("pensionFundService", "process")
                .aggregate()
                .channel("pensionerChannel")
                .get();
    }

    public static void main( String[] args ) throws Exception {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext( App.class );

        Life life = ctx.getBean( Life.class );

        ForkJoinPool pool = ForkJoinPool.commonPool();

        while ( true ) {
            Thread.sleep( 7000 );

            pool.execute( () -> {
                String listOfObjectsInString =  personList.stream().map(Object::toString).collect(Collectors.joining(","));
                log.info(String.format("Список живых: %s", listOfObjectsInString));
                List<Pensioner> deceasedList = life.process( personList );
                listOfObjectsInString =  deceasedList.stream().map(Object::toString).collect(Collectors.joining(","));
                log.info(String.format("Список мертвых: %s", listOfObjectsInString));
            } );
        }
    }
}
