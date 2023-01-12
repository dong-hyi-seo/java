package section2.item1;

/**
 * @author donghyi.seo
 * @since 2022-08-25
 * 1. 객체생성과파괴 - 생성자 대신정적 팩터리 메서드를 고려하라
 * 정적 메서드를 고려 안했을경우의 객체
 */
public class Car {

    private String name;
    private String price;
    private short year;

    /**
     * 출시가 안된 name만 존재하는 car 객체 생성
     */
    public Car(String name) {
        this.name = name;
    }

}


