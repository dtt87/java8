package com.dtt.jdk8.lambda;/**
 * Created by Lenovo on 2019/6/14.
 */

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * @author: dtt
 * @Date: 2019/6/14
 **/
public class BiOperationTest {

    public static void main(String[] args) {

        BiOperationTest biOperationTest = new BiOperationTest();
        int res = biOperationTest.cumpute(2, 3, (a, b) -> a - b);
        res = biOperationTest.min(2, 3, Integer::compareTo);
        String res2 = biOperationTest.getShort("aaa","bbbb",(a,b)-> a.length() - b.length());
        System.out.println(res2);

    }

    private int cumpute(int a, int b, BinaryOperator<Integer> binaryOperator) {
        return binaryOperator.apply(a, b);
    }

    private int min(int a, int b, Comparator<Integer> comparator) {
        return BinaryOperator.minBy(comparator).apply(a, b);
    }

    private String getShort(String a, String b, Comparator<String> comparator) {
        return BinaryOperator.minBy(comparator).apply(a, b);
    }
}
