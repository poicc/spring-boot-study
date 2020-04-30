package com.soft1851.spring.boot.verify.service;


import com.soft1851.spring.boot.verify.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @author CRQ
 */
@Service
@Validated
@Slf4j
public class UsersService {
    public String addUser(User user) {
        return "success";
    }
}
