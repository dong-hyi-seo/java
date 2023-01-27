package com.example.designpattern.factory_pattern.enum_pattern.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Card {

    private String name;
    private String id;

    public Card(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
