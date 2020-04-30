package com.soft1851.spring.boot.verify.controller;


import com.soft1851.spring.boot.verify.entity.User;
import com.soft1851.spring.boot.verify.service.UsersService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author CRQ
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UsersService usersService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody @Valid User user, BindingResult bindingResult){
        //如果有参数校验失败，会将错误信息封装成对象在BindingResult里
        for(ObjectError error:bindingResult.getAllErrors()){
            return  error.getDefaultMessage();
        }
        return usersService.addUser(user);
    }


}
