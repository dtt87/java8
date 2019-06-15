package com.dtt.jdk8;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest2 {

    public static void main(String[] args) {

        FunctionTest2 functionTest = new FunctionTest2();

        System.out.println(functionTest.compute(1, value -> value * 2, value -> value + 2));//6
        System.out.println(functionTest.compute2(1, value -> value * 2, value -> value + 2));//4

        System.out.println(functionTest.compute3(1,2,(v1,v2) -> v1 + v2));

    }

    private int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        return function1.compose(function2).apply(a);
    }
    private int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        return function1.andThen(function2).apply(a);
    }

    private int compute3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction){
        return biFunction.apply(a, b);
    }
}
