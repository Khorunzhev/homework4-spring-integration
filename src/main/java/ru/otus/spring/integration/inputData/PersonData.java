package ru.otus.spring.integration.inputData;

import ru.otus.spring.integration.domain.Person;

import java.util.List;

public class PersonData {

    public static final List<Person> PERSON_LIST = List.of(
            Person.builder().FIO("Ivanov Ivan").age(7).build(),
            Person.builder().FIO("Smirnov Smirno").age(8).build(),
            Person.builder().FIO("Petrov Petro").age(6).build());

}
