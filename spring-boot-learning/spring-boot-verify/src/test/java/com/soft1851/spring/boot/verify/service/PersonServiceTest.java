package com.soft1851.spring.boot.verify.service;

import com.soft1851.spring.boot.verify.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {
    @Resource
    private
    PersonService personService;

    @Test()
    @ExceptionHandler(ConstraintViolationException.class)
    void validatePerson() {
        Person person = new Person();
        person.setId("123");
        person.setName("Soft1851");
        person.setAge(11);
        person.setPhone("18850009000");
        person.setEmail("Soft1851@163.com");
        person.setSex("男");
        person.setRegion("China");
        personService.validatePerson(person);
    }
}