package com.example.designpattern.factory_pattern.enum_pattern.vo;

import com.example.designpattern.factory_pattern.enum_pattern.service.KakaoFactory;
import com.example.designpattern.factory_pattern.enum_pattern.service.PayService;

import java.util.function.Supplier;

public enum PayType {

    KAKAO {
        @Override
        public PayService getInstance() {
            return new KakaoFactory();
        }
    },
    KB ,
    IBK,
    WOORI,
    SINHAN;


    public Card create() {
        return getInstance().createCard();
    }

    public abstract PayService getInstance();


}
