package ru.otus.spring.integration.life.filters;

import org.springframework.integration.annotation.Filter;
import org.springframework.stereotype.Service;
import ru.otus.spring.integration.domain.Schoolboy;

public class UniversityFilter {
    @Filter
    public Boolean filterSchoolboys(Schoolboy schoolboy) {
        return schoolboy.getAvgExamScore() > 70;
    }
}
