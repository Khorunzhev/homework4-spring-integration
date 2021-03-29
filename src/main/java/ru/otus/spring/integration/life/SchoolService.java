package ru.otus.spring.integration.life;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.otus.spring.integration.domain.Person;
import ru.otus.spring.integration.domain.Schoolboy;
import ru.otus.spring.integration.life.util.RandomGenerationHelper;

@Log
@Service
@AllArgsConstructor
public class SchoolService {

    RandomGenerationHelper randomGenerationHelper;

    public Schoolboy process(Person person) {
        return Schoolboy.builder()
                .age(person.getAge() + 11)
                .avgExamScore(randomGenerationHelper
                        .genRandomDouble(50, 100))
                .FIO(person.getFIO())
                .build();
    }
}
