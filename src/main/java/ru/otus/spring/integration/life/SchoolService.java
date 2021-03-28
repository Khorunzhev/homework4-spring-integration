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

    public Schoolboy enrollIn(Person person) {
        return Schoolboy.builder()
                .age(person.getAge())
                .FIO(person.getFIO())
                .build();
    }

    public boolean filter(Person person) {
        return true;
    }

    public Schoolboy process(Schoolboy schoolboy) {
        schoolboy.setAge(schoolboy.getAge() + 11);
        schoolboy.setAvgExamScore(
                randomGenerationHelper
                        .genRandomDouble(50, 100));
        return schoolboy;
    }

}
