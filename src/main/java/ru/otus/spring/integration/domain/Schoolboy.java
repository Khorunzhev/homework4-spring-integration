package ru.otus.spring.integration.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Schoolboy extends Person {

    Double avgExamScore;
}
