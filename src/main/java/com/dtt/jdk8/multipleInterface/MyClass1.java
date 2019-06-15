package com.dtt.jdk8.multipleInterface;


/**
 * 实现多个接口，且多个接口中有同一方法，则类必须重写该方法，否则报错
 */
public class MyClass1 implements MyInterface1, MyInterface2{

    @Override
    public void myMethod() {
        System.out.println("myClass");
        //调用接口中的方法
        MyInterface1.super.myMethod();
    }

    public static void main(String[] args) {

        MyClass1 myClass1 = new MyClass1();
        myClass1.myMethod();
    }
}
