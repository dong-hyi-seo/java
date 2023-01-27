package com.example.designpattern.factory_pattern.vo;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ConcreteProductA extends ParentProduct {


    @Builder
    public ConcreteProductA(String id, String name, Integer price) {
        super(id, name, price);
    }

}
