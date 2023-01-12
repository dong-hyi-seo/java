package section2.item2;

import java.math.BigDecimal;

public class Item2SolutionCar {
    private final String name;
    private final String brand;
    private final BigDecimal price;

    private Item2SolutionCar(Builder builder) {
        this.name = builder.name;
        this.brand = builder.brand;
        this.price = builder.price;
    }

    public static class Builder {
        //필수 매개변수
        private final String name;

        //선택 매개변수
        private String brand;
        private BigDecimal price;

        //필수 매개 변수만 받는 생성자 호출
        public Builder(String name) {
            this.name = name;
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Item2SolutionCar build() {
            return new Item2SolutionCar(this);
        }
    }
}
