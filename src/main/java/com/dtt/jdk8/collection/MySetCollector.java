package com.dtt.jdk8.collection;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class MySetCollector<T> implements Collector<T, Set<T>, Set<T>> {
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoke");
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoke");
        return Set<T>::add;
        //编译报错，supplier返回的是具体的set，不一定返回的是哪个set，
        // 这里的add()若不是通用的Set就会有矛盾
//        return HashSet::add;  //编译报错，supplier返回的是具体的set，不一定返回的是哪个set，这里
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoke");
        return (set1, set2) -> {
            System.out.println("set1："+set1);

            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Set<T>> finisher() {
        System.out.println("finisher invoke");
        return Function.identity(); //直接返回结果
//        return t -> t;
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoke");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.UNORDERED));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome");
//        MySetCollector<String> mySetCollector = new MySetCollector<>();
        Set<String> set = list.stream().collect(new MySetCollector<>());
        Stream<String> stream = list.stream();

    }
}
