package ru.otus.spring.integration.life.filters;

import org.springframework.integration.annotation.Filter;
import org.springframework.stereotype.Service;
import ru.otus.spring.integration.domain.Student;

public class CompanyFilter {

    @Filter
    public Boolean filterUniversityBoys(Student student) {
        return student.getPercentOfKnowledge() > 70;
    }

}
