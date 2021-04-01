package ru.otus.spring.integration.runners;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.otus.spring.integration.domain.Pensioner;
import ru.otus.spring.integration.gateways.Life;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

import static ru.otus.spring.integration.inputData.PersonData.PERSON_LIST;

@Log
@AllArgsConstructor
@Service
public class LifeFlowRunner {

    private final Life life;

    public void run() throws InterruptedException {

        ForkJoinPool pool = ForkJoinPool.commonPool();

        while ( true ) {
            Thread.sleep( 7000 );

            pool.execute( () -> {
                String listOfObjectsInString =  PERSON_LIST.stream().map(Object::toString).collect(Collectors.joining(","));
                log.info(String.format("Список живых: %s", listOfObjectsInString));
                List<Pensioner> deceasedList = life.process( PERSON_LIST );
                listOfObjectsInString =  deceasedList.stream().map(Object::toString).collect(Collectors.joining(","));
                log.info(String.format("Список мертвых: %s", listOfObjectsInString));
            } );
        }
    }

}
