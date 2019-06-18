package com.dtt.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class Test10 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.stream().mapToInt(item -> {
            System.out.println(item);
            return item.length();
        }).filter(i -> i == 5).findFirst().ifPresent(System.out::println);
    }
}
