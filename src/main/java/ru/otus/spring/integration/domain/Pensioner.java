package ru.otus.spring.integration.domain;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@ToString(callSuper=true)
@SuperBuilder
public class Pensioner extends Person {

}
