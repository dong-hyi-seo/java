package com.example.designpattern.factory_pattern.basic.service;

import com.example.designpattern.factory_pattern.basic.vo.ProductType;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

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

        //creatorService의 구현체인 bean들을 for 문을 돌리면서 key는 제품타입, value는 서비스를 담아준다.
        for (CreatorService creatorService : creatorServiceList) {
            this.creatorServices.put(creatorService.getProductType(), creatorService);
        }
    }

    public CreatorService getService(ProductType productType) {
        return creatorServices.get(productType);
    }

}
