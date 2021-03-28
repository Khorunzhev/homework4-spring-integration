package ru.otus.spring.integration.life.util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

@Component
public class RandomGenerationHelper {

    public Double genRandomDouble(Integer rangeMin, Integer rangeMax) {
        Random r = new Random();
        return rangeMin + (rangeMax - rangeMin) * r.nextDouble();
    }
}
