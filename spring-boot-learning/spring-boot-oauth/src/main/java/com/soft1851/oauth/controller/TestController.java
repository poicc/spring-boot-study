package com.soft1851.oauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CRQ
 */
@RestController
public class TestController {
    @RequestMapping("/index")
    public String simpleIndex(){
        return "index";
    }
}
