package com.dtt.jdk8.multipleInterface;

public interface MyInterface1 {
    default void myMethod(){
        System.out.println("myInterface1");
    }
}
