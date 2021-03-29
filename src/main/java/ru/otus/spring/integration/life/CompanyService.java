package ru.otus.spring.integration.life;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.otus.spring.integration.domain.Employee;
import ru.otus.spring.integration.domain.Student;
import ru.otus.spring.integration.life.util.RandomGenerationHelper;

@Log
@AllArgsConstructor
@Service
public class CompanyService {

    RandomGenerationHelper randomGenerationHelper;

    public Employee process(Student student) {
        return Employee.builder()
                .age(student.getAge() + 60)
                .FIO(student.getFIO())
                .salary(randomGenerationHelper.genRandomDouble(50000, 500000))
                .build();
    }
}
