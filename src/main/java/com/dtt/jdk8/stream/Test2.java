package com.dtt.jdk8.stream;

import java.util.stream.IntStream;

public class Test2 {
    public static void main(String[] args) {

        IntStream.of(new int[]{5, 6, 7}).forEach(System.out::println);

        //整型特殊的创建方式
        IntStream.range(3, 8).forEach(System.out::println);//3,4,5,6,7

        IntStream.rangeClosed(3,8).forEach(System.out::println);//3,4,5,6,7,8
    }
}
