package ru.otus.spring.integration.life;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.otus.spring.integration.domain.Employee;
import ru.otus.spring.integration.domain.Pensioner;
import ru.otus.spring.integration.domain.Person;
import ru.otus.spring.integration.domain.Unemployed;
import ru.otus.spring.integration.life.util.RandomGenerationHelper;

import java.io.InvalidObjectException;

@Service
public class PensionFundService {

    @SneakyThrows
    public Pensioner process(Person person) {
        if (person instanceof Unemployed) {
            Unemployed unemployed = (Unemployed) person;
            return Pensioner.builder()
                    .pension(unemployed.getUnemploymentBenefit() / 10)
                    .FIO(unemployed.getFIO())
                    .age(unemployed.getAge() + 20)
                    .build();
        } else if (person instanceof Employee) {
            Employee employee = (Employee) person;
            return Pensioner.builder()
                    .pension(employee.getSalary() / 5)
                    .FIO(employee.getFIO())
                    .age(employee.getAge() + 20)
                    .build();
        } else {
            throw new InvalidObjectException("Передан неверный объект");
        }
    }
}
