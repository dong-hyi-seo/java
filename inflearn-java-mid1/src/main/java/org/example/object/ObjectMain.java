package org.example.object;

/**
 * Java에서 Object 클래스가 최상위 부모클래스인 이유 ?
 * 1. 공통기능제공
 * 2. 다형성의 기본 구현
 *
 * Object는 모든 객체에 필요한 공통 기능을 제공
 * toString, equals, getClass, hashcode
 */
public class ObjectMain {

    public static void main(String[] args) {

        //child를 생성하면 Patent생성되고 Patent가 생성되면 Object도 생성됨
        Child child = new Child();
        child.childMethod();
        child.parentMethod();

        //toString()은 Object 클래스의 메서드
        String string = child.toString();
        System.out.println(string);

    }
}
