package com.example.designpattern.factory_pattern.basic.service;

import org.springframework.stereotype.Service;

@Service
public class BSubService {

    public String getFactoryName() {
        return "B-Factory";
    }
}
