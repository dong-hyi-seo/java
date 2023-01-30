package com.example.designpattern.factory_pattern.basic.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ParentProduct {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private Integer price;

    @JsonProperty("factory")
    private String factory;

    protected ParentProduct() {}

    public ParentProduct(String id, String name, Integer price, String factory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.factory = factory;
    }

    @Override
    public String toString() {
        return "ParentProduct{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", factory='" + factory + '\'' +
                '}';
    }
}
