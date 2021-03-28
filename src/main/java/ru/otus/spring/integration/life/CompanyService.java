package ru.otus.spring.integration.life;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.otus.spring.integration.domain.Employee;
import ru.otus.spring.integration.domain.Student;

@Log
@Service
public class CompanyService {


    public Employee enrollIn(Student student) {
        return Employee.builder()
                .age(student.getAge())
                .FIO(student.getFIO())
                .build();
    }

    public boolean filter(Student student) {
        return student.getPercentOfKnowledge() > 75;
    }

    public Employee process(Employee employee) {
        employee.setAge(employee.getAge() + 60);
        return employee;
    }
}
