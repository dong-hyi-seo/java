package com.example.designpattern.factory_pattern.basic.controller;

import com.example.designpattern.factory_pattern.basic.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factory-pattern")
public class SendController {

    private final ProductService service;

    public SendController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/send")
    public void send() {
        service.send();
    }
}
