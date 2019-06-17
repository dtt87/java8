package com.dtt.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author: dtt
 * @Date: 2019/6/14
 **/
public class PredicateTest2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        PredicateTest2 predicateTest2 = new PredicateTest2();

        predicateTest2.conditionFilter(list, v -> v % 2 == 0);
        System.out.println("-------------------");
        predicateTest2.conditionFilter(list, v -> v > 5);
        System.out.println("-------------------");
        //打印出所有的元素
        predicateTest2.conditionFilter(list, v -> true);
        System.out.println("-------------------");
        predicateTest2.conditionFilter(list, v -> v > 5, v -> v % 2 == 0);
        System.out.println("-------------------");
        System.out.println(predicateTest2.isEqual("test").test("test"));


    }

    private void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(item -> {
            if (predicate.test(item)) {
                System.out.println(item);
            }
        });
    }

    private void conditionFilter(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
        list.forEach(item -> {
            if (predicate1.and(predicate2).negate().test(item)) {
                System.out.println(item);
            }
        });
    }

    private Predicate<String> isEqual(Object object){
        return Predicate.isEqual(object);
    }
}
