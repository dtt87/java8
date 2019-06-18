package com.dtt.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class FlatMapTest {
    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("hello", "world", "test");
        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wangwu");

        list1.stream().flatMap(item -> list2.stream().map(item2 -> item + " " + item2)).forEach(System.out::println);
        list1.stream().flatMap(item -> list2.stream().map(item2 -> item + " " + item2)).forEach(System.out::println);

    }
}
