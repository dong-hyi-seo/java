package com.example.designpattern.factory_pattern.enum_pattern.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KbCard extends Card {

    private Integer kbPoint;

    public KbCard(String name, String id, Integer kbPoint) {
        super(name, id);
        this.kbPoint = kbPoint;
    }
}
