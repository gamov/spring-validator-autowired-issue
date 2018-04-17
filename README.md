# Purpose
This is to support Spring Boot issue #xxx https://github.com/spring-projects/spring-boot/issues/xxx

The goal is to autowire a custom javax.validation.ConstraintValidator (PersonValidator) with a service (PersonService) to perform a validation.
The issue is that the service is **not** autowired if call from JPA/Hibernate. It works if you call the Spring managed validator directly.

This goes against the feature explained here:

https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#validation-beanvalidation-spring-constraints  

### Run

    mvn test -DtrimStackTrace=false

Observe the direct validator being autowired, but NOT the one attached by Hibernate, we get a null pointer exception:

```
Caused by: java.lang.NullPointerException
	at com.example.demo.PersonConstraintValidator.isValid(PersonConstraintValidator.java:29)
	at com.example.demo.PersonConstraintValidator.isValid(PersonConstraintValidator.java:9)
	at org.hibernate.validator.internal.engine.constraintvalidation.ConstraintTree.validateSingleConstraint(ConstraintTree.java:171)
	... 78 more
```

