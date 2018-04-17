package com.example.demo;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @NameConstraint
    private String name;

    @Min(0)
    private int age;
}
