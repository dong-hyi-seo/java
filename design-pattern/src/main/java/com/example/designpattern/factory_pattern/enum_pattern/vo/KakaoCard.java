package com.example.designpattern.factory_pattern.enum_pattern.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KakaoCard extends Card {

    private Integer kakaoPoint;


    public KakaoCard(String name, String id, Integer kakaoPoint) {
        super(name, id);
        this.kakaoPoint = kakaoPoint;
    }
}
