package ru.otus.spring.integration.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class Person {
    private String FIO;
    private Integer age;
    private Double pension;
}
