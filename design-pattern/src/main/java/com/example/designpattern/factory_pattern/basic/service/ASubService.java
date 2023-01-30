package com.example.designpattern.factory_pattern.basic.service;

import org.springframework.stereotype.Service;

@Service
public class ASubService {

    public String getFactoryName() {
        return "A-Factory";
    }
}
