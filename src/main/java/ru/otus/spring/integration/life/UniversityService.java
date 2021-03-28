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

    public Student enrollIn(Schoolboy schoolboy) {
        return Student.builder()
                .age(schoolboy.getAge())
                .FIO(schoolboy.getFIO())
                .build();
    }

    public Student process(Student student) {
        student.setAge(student.getAge() + 6);
        student.setPercentOfKnowledge(
                randomGenerationHelper
                        .genRandomDouble(50, 100));
        return student;
    }

}
