package com.example.designpattern.factory_pattern.service;

import com.example.designpattern.factory_pattern.vo.ConcreteProductA;
import com.example.designpattern.factory_pattern.vo.ParentProduct;
import com.example.designpattern.factory_pattern.vo.ProductType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CreatorServiceFactoryTest {

    @Autowired
    private CreatorServiceFactory creatorServiceFactory;

    @Test
    void 제품_타입별로_서비스_가져오기() {

        //given
        ProductType aType = ProductType.PRODUCTA;
        ProductType bType = ProductType.PRODUCTB;

        //when
        CreatorService aTypeService = creatorServiceFactory.getService(aType);
        CreatorService bTypeService = creatorServiceFactory.getService(bType);

        ParentProduct aProduct = aTypeService.createProduct();
        System.out.println("aProduct = " + aProduct.toString());
        ParentProduct bProduct = bTypeService.createProduct();
        System.out.println("bProduct = " + bProduct.toString());
        //then
        Assertions.assertThat(aTypeService.getProductType()).isEqualTo(ProductType.PRODUCTA);
        Assertions.assertThat(aTypeService.getProductType()).isEqualTo(ProductType.PRODUCTA);

    }
}