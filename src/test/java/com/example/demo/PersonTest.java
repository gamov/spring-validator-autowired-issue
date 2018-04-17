package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.Validator;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonTest {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    Validator validator;

    @Test
    public void ValidatePersonViaValidator() {

        Person p = Person.builder()
                .age(1)
                .name("Gam")
                .build();

        assertThat(validator.validate(p).size()).isEqualTo(1);
    }

    @Test
    public void ValidatePersonViaJPA() {

        Person p = Person.builder()
                .age(1)
                .name("Gam")
                .build();

        personRepository.save(p);

        assertThat(personRepository.count()).isZero();
    }
}
