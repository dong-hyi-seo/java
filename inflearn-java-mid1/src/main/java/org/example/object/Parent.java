package org.example.object;

//묵시적 상속
//부모가 없으면 묵시적으로 Object 클래스를 상속받는다. extends Object
public class Parent {

    public void parentMethod() {
        System.out.println("Parent. parentMethod");
    }
}
