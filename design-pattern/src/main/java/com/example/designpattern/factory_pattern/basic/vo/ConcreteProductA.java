package com.example.designpattern.factory_pattern.basic.vo;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ConcreteProductA extends ParentProduct {


    @Builder
    public ConcreteProductA(String id, String name, Integer price, String factory) {
        super(id, name, price, factory);
    }
}
