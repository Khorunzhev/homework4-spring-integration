package ru.otus.spring.integration.life;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.otus.spring.integration.domain.*;

@Log
@Service
public class LifeEndSerivce {

    public Deceased process(Pensioner pensioner) {
        return Deceased.builder()
                .age(pensioner.getAge())
                .FIO(pensioner.getFIO())
                .build();
    }

}
