package com.dtt.jdk8.multipleInterface;


/**
 * 类继承一父类，实现一接口，且父类和接口中都有同一方法，
 * 父类的优先级高，类会调用父类当中的方法
 */
public class MyClass2 extends MyInterface1Impl implements MyInterface2{

    public static void main(String[] args) {
        MyClass2 myClass2 = new MyClass2();
        myClass2.myMethod();// myInterface1Impl
    }
}
