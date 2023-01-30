package com.example.designpattern.factory_pattern.service;

import com.example.designpattern.factory_pattern.basic.service.CreatorService;
import com.example.designpattern.factory_pattern.basic.service.CreatorServiceFactory;
import com.example.designpattern.factory_pattern.basic.vo.ParentProduct;
import com.example.designpattern.factory_pattern.basic.vo.ProductType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CreatorServiceFactoryTest {

    @Autowired
    private CreatorServiceFactory creatorServiceFactory;

    @Test
    void 제품_타입별로_서비스_가져오기() {

        //given
        ProductType meat = ProductType.MEAT;
        ProductType snack = ProductType.SNACK;

        //when
        CreatorService aFactoryService = creatorServiceFactory.getService(meat);
        CreatorService bFactoryService = creatorServiceFactory.getService(snack);

        ParentProduct aProduct = aFactoryService.createProduct();
        System.out.println("aProduct = " + aProduct.toString());
        ParentProduct bProduct = bFactoryService.createProduct();
        System.out.println("bProduct = " + bProduct.toString());

        //then


    }
}