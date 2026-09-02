package com.demo.springboot.demo.demoapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunnyRestController {
    //expose "/" that returns "Hello World!"
    @GetMapping("/")
    public String sayHello()
    {
        return "Hello World!";
    }
}
