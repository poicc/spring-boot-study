package com.soft1851.spring.boot.verify.service;

import com.soft1851.spring.boot.verify.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @author CRQ
 */
@Service
@Validated
@Slf4j
public class PersonService {
    public void validatePerson(@Valid Person person){
        log.info("service方法验证");
    }
}
