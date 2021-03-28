package ru.otus.spring.integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.otus.spring.integration.domain.Deceased;
import ru.otus.spring.integration.domain.Person;

import java.util.List;

@MessagingGateway
public interface Life {

    @Gateway(requestChannel = "personChannel", replyChannel = "deceasedChannel")
    List<Deceased> process(List<Person> orderItem);

}
