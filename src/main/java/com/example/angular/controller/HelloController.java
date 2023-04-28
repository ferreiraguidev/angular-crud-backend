package com.example.angular.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class HelloController {


    @ResponseStatus(OK)
    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }
}
