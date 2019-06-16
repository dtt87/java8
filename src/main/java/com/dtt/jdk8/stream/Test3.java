package com.dtt.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list.stream().mapToInt(x -> x * 2).sum());
        System.out.println(list.stream().map(x -> x * 2).reduce(0, Integer::sum));
    }
}
