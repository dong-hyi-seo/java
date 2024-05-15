package org.example.object.poly;

public class ObjectPolyExample2 {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Car car = new Car();

        Object object = new Object(); //Object도 인스턴스를 만들 수있다.
        Object[] objects = {dog, car, object};

        size(objects);
    }

    //Object 더분에 모든 객체를 담을 수있으며 사이즈도 구하는게 가능
    private static void size(Object[] objects) {
        System.out.println("전달 된 객체의 수는 : " + objects.length);
    }
}
