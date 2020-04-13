package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.annotation.AuthToken;
import com.soft1851.springboot.aop.annotation.ControllerWebLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CRQ
 */
@RestController
@Slf4j
public class UserController {

    /**
     * 无需任何校验，不用加注解
     * @param name
     * @return
     */
    @GetMapping("hello")
    @ControllerWebLog(name = "getHello", isSaved = true)
    public String hello(String name){
        log.info("hello()方法无需鉴权，也无需认证,当前用户名："+name);
        return  "hello方法访问成功";
    }

    /**
     * 需要登陆的校验,此时该方法需要加注解，但不需要传角色
     * @param name
     * @return String
     */
    @GetMapping("user")
    @AuthToken
    @ControllerWebLog(name = "getHello", isSaved = true)
    public String user(String name){
        log.info("hello()方法无需鉴权，需要认证,当前用户名："+name);
        return "user()方法访问成功";
    }

    /**
     * 需要登陆的校验,此时该方法需要加注解，且需要传角色
     * 角色可以传多个
     * 如果需要更复杂的逻辑操作，建议使用框架：Spring Security,Apache Spring等框架
     * @param name
     * @return String
     */
    @GetMapping("admin")
    @AuthToken(role_name = {"admin","Admin"})
    @ControllerWebLog(name = "getHello", isSaved = true)
    public String admin(String name){
        log.info("hello()方法需要鉴权,当前用户名："+name);
        return "admin()方法响应成功";
    }

}
