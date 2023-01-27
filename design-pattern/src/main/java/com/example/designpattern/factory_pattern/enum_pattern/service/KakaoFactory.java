package com.example.designpattern.factory_pattern.enum_pattern.service;

import com.example.designpattern.factory_pattern.enum_pattern.vo.Card;
import org.springframework.stereotype.Component;

@Component
public class KakaoFactory implements PayService {
    @Override
    public Card createCard() {
        return null;
    }
}
