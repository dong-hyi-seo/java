package org.example.object.tostring;

public class ToStringMain2 {


    public static void main(String[] args) {
        Car car = new Car("Model Y");
        Dog dog1 = new Dog("멍멍이1", 2);
        Dog dog2 = new Dog("멍멍이2", 5);

        System.out.println("1. 단순 toString 호출");
        System.out.println("car = " + car.toString());
        System.out.println("dog1 = " + dog1.toString());
        System.out.println("dog2 = " + dog2.toString());

        System.out.println("2. println에서 호출");
        System.out.println("car = " + car);
        System.out.println("dog1 = " + dog1);
        System.out.println("dog2 = " + dog2);

        System.out.println("3. ObjectPrint 활용 호출");
        ObjectPrinter.print("car = " + car);
        ObjectPrinter.print("dog1 = " + dog1);
        ObjectPrinter.print("dog2 = " + dog2);
    }
}
