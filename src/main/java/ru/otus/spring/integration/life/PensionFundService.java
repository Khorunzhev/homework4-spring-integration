package ru.otus.spring.integration.life;

import org.springframework.stereotype.Service;
import ru.otus.spring.integration.domain.Pensioner;
import ru.otus.spring.integration.domain.Person;
import ru.otus.spring.integration.life.util.RandomGenerationHelper;

@Service
public class PensionFundService {

    RandomGenerationHelper randomGenerationHelper;

    public Pensioner enrollIn(Person afterGraduatePerson) {
        return Pensioner.builder()
                .age(afterGraduatePerson.getAge())
                .FIO(afterGraduatePerson.getFIO())
                .build();
    }

    public boolean filter(Person person) {
        return true;
    }

    public Pensioner process(Pensioner pensioner) {
        pensioner.setPension(25000.0);
        pensioner.setAge(pensioner.getAge() + 20);
        return pensioner;
    }

}
