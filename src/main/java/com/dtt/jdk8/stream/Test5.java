package com.dtt.jdk8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test5 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world","test");
        List<String> res = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(res.toString());

        //扁平化map，stream中的每个元素是集合类型的，flapMap会将每个集合中的元素拿出来组合成为一个流
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1),Arrays.asList(2,3),Arrays.asList(4,5,6));
        lists.stream().flatMap(theList->theList.stream()).map(i->i*2).forEach(System.out::println);
    }
}
