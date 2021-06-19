package com.example.demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestV1 {

    @RequestMapping("/setName")
    public String setName(){
        return "123";
    }
}
