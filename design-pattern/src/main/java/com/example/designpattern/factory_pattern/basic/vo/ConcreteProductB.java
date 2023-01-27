package com.example.designpattern.factory_pattern.basic.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ConcreteProductB extends ParentProduct {

    @JsonProperty("something")
    private String something;


    @Builder
    public ConcreteProductB(String id, String name, Integer price, String something) {
        super(id, name, price);
        this.something = something;
    }

    @Override
    public String toString() {
        return "ConcreteProductB{" +
                "something='" + something + '\'' +
                '}';
    }
}
