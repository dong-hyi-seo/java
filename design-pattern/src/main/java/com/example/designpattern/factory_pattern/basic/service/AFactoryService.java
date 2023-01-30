package com.example.designpattern.factory_pattern.basic.service;

import com.example.designpattern.factory_pattern.basic.vo.ConcreteProductA;
import com.example.designpattern.factory_pattern.basic.vo.FactoryType;
import com.example.designpattern.factory_pattern.basic.vo.ParentProduct;
import com.example.designpattern.factory_pattern.basic.vo.ProductType;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AFactoryService implements CreatorService {

    private final ASubService aSubService;

    public AFactoryService(ASubService aSubService) {
        this.aSubService = aSubService;
    }

    @Override
    public FactoryType getFactoryType() {
        return FactoryType.AFactory;
    }


    @Override
    public ParentProduct createProduct() {
        return ConcreteProductA.builder().id(String.valueOf(UUID.randomUUID()))
                .price(2000)
                .name("A제품")
                .factory(aSubService.getFactoryName())
                .build();
    }
}
