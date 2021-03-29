package ru.otus.spring.integration.life;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.otus.spring.integration.domain.Employee;
import ru.otus.spring.integration.domain.Student;

@Log
@Service
public class CompanyService {

    public Employee process(Student student) {
        return Employee.builder()
                .age(student.getAge() + 60)
                .FIO(student.getFIO())
                .build();
    }
}
