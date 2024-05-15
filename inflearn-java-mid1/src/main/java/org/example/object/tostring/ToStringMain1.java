package org.example.object.tostring;

public class ToStringMain1 {

    public static void main(String[] args) {
        Object object = new Object();
        String string = object.toString();

        /**
         * `Object` 가 제공하는 `toString()` 메서드는 기본적으로 패키지를 포함한 객체의 이름과 객체의 참조값(해시 코드)를 16진수로 제공한다.
         */
        //hashcode : 객체의 참조값 -> toHex 16진수
        System.out.println(string);

        System.out.println(object);

    }
}
