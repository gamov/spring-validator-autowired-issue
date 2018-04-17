package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PersonConstraintValidator implements ConstraintValidator<NameConstraint, String> {

    private PersonService personService;

    public PersonConstraintValidator() {
        System.out.println("Instantiated by Hibernate");
    }

    @Autowired
    public PersonConstraintValidator(PersonService personService) {
        System.out.println("Instantiated by Spring");
        this.personService = personService;
    }

    @Override
    public void initialize(NameConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return personService.doesNameExist(value);
    }
}
