package section2.item1;

import java.lang.reflect.Constructor;

public interface Laptop {
    //인터페이스가 정적 메서드를 직접 갖을수있다. (java 8부터!!)
    static Laptop lowQualityLaptop() {
        return new LowQualityLaptop();
    }

    static Laptop normalLaptop() {
        return new NormalLaptop();
    }

    static Laptop highEndLaptop() {
        return new HighEndLaptop();
    }

    static Laptop getLaptop(String type) throws Exception {
        if (type.equals("low")) {
            return new LowQualityLaptop();
        } else if (type.equals("nomal")) {
            return new NormalLaptop();
        } else if (type.equals("high")) {
            Laptop highLaptop = null;
            try {
                // 5. 정적 팩토리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도된다.
                Constructor<?> highLaptopConstructor = Class
                        .forName("section2.item1.HighEndLaptop")
                        .getConstructor();
                highLaptop  = (Laptop) highLaptopConstructor.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return highLaptop;
        }
        throw new Exception("해당 컴퓨터를 찾을 수 없습니다.");
    }

    void turnOn();
}
