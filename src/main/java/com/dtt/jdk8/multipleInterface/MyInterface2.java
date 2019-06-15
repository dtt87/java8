package com.dtt.jdk8.multipleInterface;

public interface MyInterface2 {
    default void myMethod(){
        System.out.println("myInterface2");
    }
}
