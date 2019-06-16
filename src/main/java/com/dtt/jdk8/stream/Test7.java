package com.dtt.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Test7 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "test");

        /**
         * 不会打印任何信息
         * 原因：map()是中间操作，根据惰性定律，没有终止操作是不会执行的
         */
        list.stream().map(item -> {
            String result = item.substring(0, 1).toUpperCase() + item.substring(1);
            System.out.println("test");
            return result;
        });

        IntStream.iterate(0, i -> (i + 1) % 2).distinct().limit(6).forEach(System.out::println);
    }
}
