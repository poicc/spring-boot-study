package com.soft1851.springboot.aop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author CRQ
 */
@SpringBootApplication
@MapperScan("com.soft1851.springboot.aop.mapper")
@ComponentScan("com.soft1851.springboot.aop.service")
@ComponentScan("com.soft1851.springboot.aop.controller")
public class SpringBootAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAopApplication.class, args);
    }

}
