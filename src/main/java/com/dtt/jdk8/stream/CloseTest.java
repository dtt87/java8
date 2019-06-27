package com.dtt.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CloseTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "test");

        NullPointerException nullPointerException = new NullPointerException("my exception");

        try(Stream<String> stream = list.stream()) {//这个try()方法会默认调用close()方法，因为stream继承了AutoClose类
            //抛出异常不会影响其他函数执行
            stream.onClose(() -> {
                System.out.println("aaa");
//                throw new NullPointerException();
//                throw nullPointerException; // 同一个异常对象异常不会被压制
                throw new NullPointerException("first");
            }).onClose(() -> {
                System.out.println("bbb");
//                throw new ArithmeticException();
//                throw nullPointerException;
                throw new NullPointerException("second");
            }).forEach(System.out::println);
        }

    }
}
