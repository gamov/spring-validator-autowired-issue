package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

    @Autowired
    PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Scheduled(cron = "* */1 * * * *")
    void postConstruct() {
        Person p = Person.builder()
                .name("GAM")
                .build();

        personRepository.save(p);

        System.out.println(personRepository.findAll().iterator().next().getName());
    }
}
