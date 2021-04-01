package ru.otus.spring.integration;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;
import ru.otus.spring.integration.runners.LifeFlowRunner;

@Log
@IntegrationComponentScan
@EnableIntegration
@SpringBootApplication
public class MainApp {


    public static void main( String[] args ) throws InterruptedException {
        ApplicationContext app = SpringApplication.run(MainApp.class, args);
        LifeFlowRunner lifeFlowRunner = app.getBean(LifeFlowRunner.class);
        lifeFlowRunner.run();
    }
}
