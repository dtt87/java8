package com.dtt.jdk8.lambda;

import java.util.*;

public class StringComparator {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("zhangsan","lisi","wangwu");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        Collections.sort(names, Comparator.reverseOrder());

        System.out.println(names);
    }
}
