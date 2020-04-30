package com.soft1851.spring.boot.verify.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soft1851.spring.boot.verify.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.validation.*;
import java.util.Set;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void savePerson() throws Exception{
        //创建对象
        Person person=  new Person();
        person.setId("123456");
        person.setName("Soft1851");
        person.setAge(20);
        person.setPhone("18850009000");
        person.setEmail("Soft1851@163.com");
        person.setSex("Man");
        person.setRegion("China");
        //创建请求，包括url、请求类型、内容（使用 ObjectMapper简化繁琐的JOSN串拼接）
        MockHttpServletRequestBuilder requestBuilder= MockMvcRequestBuilders
                .post("/api/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(person));
        //mockMvc执行请求，判断结果是否匹配
        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    /**
     * @PathVariables参数的校验getPersonById
     * @throws Exception
     */
    @Test
    void getPersonById() throws Exception {
        //路径参数不需要设置内容，类型选text/plain
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/person/1122")
                .contentType(MediaType.TEXT_PLAIN);

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string("getPersonById.id:id不能小于6位"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    /**
     * @RequestParam参数的校验
     */
    @Test
    void getPersonByName() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/person")
                .contentType(MediaType.APPLICATION_JSON)
                .param("name","soft18518151");

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string("getPersonVyName.name:name长度超出范围"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

    @Test
    void checkManually(){
        //通过Validator工厂类获得的Validator实列，也可以通过注入的方式
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Person person = new Person();
        person.setId("123");
        person.setSex("Man22");
        person.setEmail("abc");
        //对参数进行校验，得到一组结果
        Set<ConstraintViolation<Person>> validators = validator.validate(person);
        for (ConstraintViolation<Person> constraintViolation : validators){
            System.out.println(constraintViolation.getMessage());
        }


    }
}