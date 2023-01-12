package section2.item2;

import java.math.BigDecimal;

/**
 * @author donghyi.seo
 * @since 2022-09-01
 * item2. 생성자에 매개변수가 많다면 빌더를 고려하라
 */
public class Item2Car {

    private String name;
    private String brand;
    private BigDecimal price;

    public Item2Car() {}

    //아래 생성자들 같이 여러개 만들경우 ? -> 점층적 생성자 패턴
    //요약하면, 점측적 생성자 패턴도 쓸 수는 있지만, 매개변수 개수가 많아지면 클라이언트 코드를 작성하거나 읽기 어렵다.
    public Item2Car(String name, String brand, BigDecimal price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public Item2Car(String name) {
        this.name = name;
    }

    public Item2Car(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
