package ru.otus.spring.integration.gateways;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.otus.spring.integration.domain.Pensioner;
import ru.otus.spring.integration.domain.Person;

import java.util.List;

@MessagingGateway
public interface Life {

    @Gateway(requestChannel = "personChannel", replyChannel = "pensionerChannel")
    List<Pensioner> process(List<Person> orderItem);

}
