package com.dtt.jdk8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author: dtt
 * @Date: 2019/6/12
 **/

public class Test3 {

    public static void main(String[] args){
        MyInterface1 i1 = () -> {};
        System.out.println(i1.getClass().getInterfaces()[0]);

        MyInterface2 i2 = () -> {};
        System.out.println(i2.getClass().getInterfaces()[0]);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello!");
            }
        });
        new Thread(() -> {System.out.println("Hello!");}).start();

        List<String> list = Arrays.asList("hello", "world");
        list.forEach(i -> {
            System.out.println(i.toUpperCase());
        });

        List<String> list2 = new ArrayList<>();
        //串行流
        list.stream().map(item -> item.toUpperCase()).forEach(i -> System.out.println(i));
        list.stream().map(String::toUpperCase).forEach(i -> System.out.println(i));

        //并行流
        list.parallelStream();

        Function<String, String> function = String::toUpperCase;
        System.out.println();
    }
}

@FunctionalInterface
interface MyInterface1{
    void myMethod1();
}

@FunctionalInterface
interface MyInterface2{
    void myMethod2();
}
