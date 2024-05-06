package org.example.object.poly;

public class ObjectPolyExample1 {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Car car = new Car();

        action(dog);
        action(car);
    }

    /**
     * Object 다형적 참초만 가능..
     * 다형성 활용측면에서 한계..
     * 그렇다면 Object를 언제활용 ?
     */
    private static void action(Object obj) {
        //호출안됨 (컴파일 오류)
        //obj.sound //object는 sound함수가 없음
        //obj.move // object는 move 함수 없음

        //굳이 사용하려면 down casting
        if (obj instanceof Dog dog) {
            dog.sound();
        } else if (obj instanceof Car car) {
            car.move();
        }
    }
}
