package com.dtt.jdk8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test4 {
    public static void main(String[] args) {

        Stream<String> stringStream = Stream.of("hello", "world", "helloworld");

        //将流转换为数组
        String[] strings = stringStream.toArray(String[]::new);
        Arrays.asList(strings).forEach(System.out::println);

        //将流转换为集合
        //方式1，但仅限于返回ArrayList
        List<String> list = stringStream.collect(Collectors.toList());
        //方式2，Lambda
        List<String> list1 = stringStream.collect(() -> new ArrayList<>(),
                (theList, item) -> theList.add(item),
                (theList1, theList2) -> theList1.addAll(theList2));
        //方式3，类名::实例方法
        List<String> list2 = stringStream.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        //方式4，可以返回除了ArrayList意外的类型
        List<String> list3 = stringStream.collect(Collectors.toCollection(LinkedList::new));
        Set<String> set = stringStream.collect(Collectors.toCollection(TreeSet::new));

        //流转换为字符串
        //方式1，复杂的方法引用形式
        String string = stringStream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        //方式2，比较简便的方式
        String string2 = stringStream.collect(Collectors.joining());

    }
}
