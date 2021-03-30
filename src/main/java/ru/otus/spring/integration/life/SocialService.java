package ru.otus.spring.integration.life;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.otus.spring.integration.domain.*;
import ru.otus.spring.integration.life.util.RandomGenerationHelper;

@Log
@AllArgsConstructor
@Service
public class SocialService {

    RandomGenerationHelper randomGenerationHelper;

    public Unemployed process(Person employee) {
        return Unemployed.builder()
                .age(employee.getAge() + 60)
                .FIO(employee.getFIO())
                .unemploymentBenefit(randomGenerationHelper
                        .genRandomDouble(7500, 15000))
                .build();
    }
}
