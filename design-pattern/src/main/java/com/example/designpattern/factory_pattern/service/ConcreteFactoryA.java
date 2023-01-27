package com.example.designpattern.factory_pattern.service;

import com.example.designpattern.factory_pattern.vo.ConcreteProductA;
import com.example.designpattern.factory_pattern.vo.ParentProduct;
import com.example.designpattern.factory_pattern.vo.ProductType;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ConcreteFactoryA implements CreatorService {
    @Override
    public ProductType getProductType() {
        return ProductType.PRODUCTA;
    }

    @Override
    public ParentProduct createProduct() {
        return ConcreteProductA.builder().id(String.valueOf(UUID.randomUUID()))
                .price(2000)
                .name("A제품").build();
    }
}
