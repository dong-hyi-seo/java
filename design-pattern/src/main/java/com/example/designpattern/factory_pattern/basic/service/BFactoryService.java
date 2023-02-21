package com.example.designpattern.factory_pattern.basic.service;

import com.example.designpattern.factory_pattern.basic.vo.ConcreteProductB;
import com.example.designpattern.factory_pattern.basic.vo.FactoryType;
import com.example.designpattern.factory_pattern.basic.vo.ParentProduct;
import com.example.designpattern.factory_pattern.basic.vo.ProductType;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BFactoryService implements CreatorService {

    private final BSubService bSubService;

    public BFactoryService(BSubService bSubService) {
        this.bSubService = bSubService;
    }

    @Override
    public FactoryType getFactoryType() {
        return FactoryType.BFactory;
    }

    @Override
    public ParentProduct createProduct() {
        return ConcreteProductB.builder().id(String.valueOf(UUID.randomUUID()))
                .price(1000)
                .name("B제품")
                .factory(bSubService.getFactoryName())
                .something("난 달라요!")
                .build();
    }
}
