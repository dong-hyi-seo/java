package com.example.firstservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8081/welcome
//http://localhost:8081/first-service/welcome
@RestController
@RequestMapping("/first-service")
public class FirstServiceController {
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the First service.";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header){
        System.out.println(header);
        return "Hello World in First Service";
    }

    @GetMapping("/check")
    public String check() {
        return "Hi, there. This is a message from First Service";
    }
}