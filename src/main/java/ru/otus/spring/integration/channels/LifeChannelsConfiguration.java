package ru.otus.spring.integration.channels;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.scheduling.PollerMetadata;

@Configuration
public class LifeChannelsConfiguration {

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        return Pollers.fixedRate( 100 ).maxMessagesPerPoll( 2 ).get();
    }

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
    public QueueChannel activeLifeEndChannel() {
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
}
