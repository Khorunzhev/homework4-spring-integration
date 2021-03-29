package ru.otus.spring.integration.life;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.otus.spring.integration.domain.Schoolboy;
import ru.otus.spring.integration.domain.Student;
import ru.otus.spring.integration.life.util.RandomGenerationHelper;

@Log
@Service
@AllArgsConstructor
public class UniversityService {

    RandomGenerationHelper randomGenerationHelper;

    public Student process(Schoolboy schoolboy) {
        return Student.builder()
                .age(schoolboy.getAge() + 6)
                .FIO(schoolboy.getFIO())
                .percentOfKnowledge(randomGenerationHelper
                        .genRandomDouble(50, 100))
                .build();
    }

}
