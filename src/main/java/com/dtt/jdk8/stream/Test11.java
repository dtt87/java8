package com.dtt.jdk8.stream;


import java.util.Arrays;
import java.util.List;

public class Test11 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world hello");

        list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);


    }


}
