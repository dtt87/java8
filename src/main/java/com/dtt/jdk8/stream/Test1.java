package com.dtt.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String[] args) {
        /**
         * 创建流的几种方式
         */

        Stream stream1 = Stream.of("hello", "world");

        String[] myArray = new String[]{"hello", "world"};
        Stream stream2 = Arrays.stream(myArray);

        List<String> list = Arrays.asList("hello", "world");
        Stream stream3 = list.stream();

        Stream stream4 = Stream.generate(String::new);
        stream4.findFirst().ifPresent(System.out::println);
    }
}
