package ru.otus.spring.integration.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Student extends Person {

    Double percentOfKnowledge;

}
