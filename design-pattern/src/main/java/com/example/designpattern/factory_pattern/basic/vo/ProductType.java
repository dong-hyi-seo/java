package com.example.designpattern.factory_pattern.basic.vo;

import lombok.Getter;

@Getter
public enum ProductType {

    MEAT(FactoryType.AFactory),
    DRINK(FactoryType.AFactory),
    SNACK(FactoryType.BFactory),
    WATER(FactoryType.BFactory);

    final FactoryType factoryType;

    ProductType(FactoryType factoryType) {
        this.factoryType = factoryType;
    }
}
