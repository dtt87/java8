package com.dtt.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);

        //匿名内部类写法
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        //Lambda写法
        list.forEach(i -> {
            System.out.println(i);
        });

        //方法引用
        list.forEach(System.out::println);
    }
}
