package com.study.java8.java8to11;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        Function<Integer, Integer> plus10 = (i) -> i + 10;
        Function<Integer, Integer> multiply = (i) -> i * 2;
        System.out.println(plus10.apply(10));
        System.out.println(multiply.apply(10));

        //위 함수 조합 (고차함수 사용)
        //compose *2 실행후 10을 더한다
        Function<Integer, Integer> multiplyAndPlus10 = plus10.compose(multiply);
        System.out.println("compose : " + multiplyAndPlus10.apply(10));

        //andThen : +10을 한뒤 *2를한다.
        System.out.println("andThen : " + plus10.andThen(multiply).apply(10));

        //인자 값을 두개 받음
        BiFunction<Integer, Integer, Integer> plus10Bi = (i, a) -> i + a + 10;
        System.out.println("BiFunction : " + plus10Bi.apply(10, 10)); // 결과 30

        //Consumer : 인자값을 받아도 리턴 안하는 함수 인터페이스 (void만 존재)
        Consumer<Integer> consumerPrint = System.out::println;
        consumerPrint.accept(10);

        //Supplier : 받을 값을 정의
        Supplier<Integer> get10 = () -> 10;
        System.out.println("Supplier : " + get10.get());

        //Predicate : T타입을 받아 boolean 타입 리턴하는 함수 인터페이스
        Predicate<String> startWithDongHyi = (s) -> s.startsWith("dong");

        //UnaryOperator : Function<T, R>의 특수한 형태로, 입력값 하나를 받아서 동일한 타입을 리턴하는 함수형 인터페이스
        UnaryOperator<Integer> unaryOperatorPlus10 = (i) -> i + 10;
        UnaryOperator<Integer>ㅡunaryOperatorMultiply = (i) -> i * 2;
        System.out.println("UnaryOperator andThen : " + unaryOperatorPlus10.andThen(ㅡunaryOperatorMultiply).apply(10));

    }
}
