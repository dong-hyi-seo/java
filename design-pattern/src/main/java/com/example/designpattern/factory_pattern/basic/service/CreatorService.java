package com.example.designpattern.factory_pattern.basic.service;

import com.example.designpattern.factory_pattern.basic.vo.FactoryType;
import com.example.designpattern.factory_pattern.basic.vo.ParentProduct;
import com.example.designpattern.factory_pattern.basic.vo.ProductType;

/**
 * 공장객체 추상화 클래스
 */
public interface CreatorService {



    default FactoryType getFactoryTypeByProductType(ProductType productType) {
        if (productType.getFactoryType() != getFactoryType()) {
            return null;
        }
        return productType.getFactoryType();
    }

    FactoryType getFactoryType();

    ParentProduct createProduct();
}
