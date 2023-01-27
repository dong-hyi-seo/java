package com.example.designpattern.factory_pattern.basic.service;

import com.example.designpattern.factory_pattern.basic.vo.ParentProduct;
import com.example.designpattern.factory_pattern.basic.vo.ProductType;

/**
 * 공장객체 추상화 클래스
 */
interface CreatorService {

    //객체 생성 전처리 후처리 메소드 (final로 오버라이딩 방지, 템플릿화)

    ProductType getProductType();

    ParentProduct createProduct();
}
