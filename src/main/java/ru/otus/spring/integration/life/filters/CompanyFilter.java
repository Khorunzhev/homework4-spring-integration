package ru.otus.spring.integration.life.filters;

import org.springframework.integration.annotation.Filter;
import org.springframework.stereotype.Service;
import ru.otus.spring.integration.domain.Schoolboy;

@Service
public class CompanyFilter {

    @Filter
    public Boolean filterUniversityBoys(Schoolboy schoolboy) {
        return schoolboy.getAvgExamScore() > 70;
    }

}
