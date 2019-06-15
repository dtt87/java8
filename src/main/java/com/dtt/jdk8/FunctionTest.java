package com.dtt.jdk8;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {

        FunctionTest functionTest = new FunctionTest();

        System.out.println(functionTest.compute(1, value -> {return 2 * value;}));
        System.out.println(functionTest.compute(1, value ->  5 + value));

        System.out.println(functionTest.convert(2, a -> String.valueOf(a)+"hello"));


    }

    private int compute(int a, Function<Integer, Integer> function){
        int result = function.apply(a);
        return result;
    }

    private String convert(int a, Function<Integer, String> function){
        return function.apply(a);
    }

}
