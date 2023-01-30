package com.example.designpattern.factory_pattern.basic.service;

import com.example.designpattern.factory_pattern.basic.vo.ProductType;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CreatorServiceFactory {

    private final Map<ProductType, CreatorService> creatorServices = new HashMap<>();

    //생성자 주입으로 CreatorService를 상속하고 있는 bean들을 주입받는다.
    public CreatorServiceFactory(List<CreatorService> creatorServiceList) {

        if (CollectionUtils.isEmpty(creatorServiceList)) {
            throw new IllegalArgumentException("존재하는 creator service가 없다.");
        }
        for (ProductType productType : ProductType.values()) {
            System.out.println("================================");
            System.out.println("product type : " + productType);
            //product type에 맞는 creator service를 찾아야함
            CreatorService creatorService = creatorServiceList.stream()
                    .filter(p -> {
                        return p.getFactoryTypeByProductType(productType) == productType.getFactoryType();
                    })
                    .findAny().get();
            System.out.println("creatorService = " + creatorService);
            this.creatorServices.put(productType, creatorService);
        }
        System.out.println("creatorServices = " + creatorServices);
    }

    public CreatorService getService(ProductType productType) {
        return creatorServices.get(productType);
    }

}
