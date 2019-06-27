package com.dtt.jdk8.collection;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MySetToMapCollector<T> implements Collector<T, Set<T>, Map<T, T>> {

    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoke");
//        return HashSet::new;
        return ()->{
            System.out.println("----------");
            return new HashSet<>();};
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoke");
        return (set, item) -> {
            set.add(item);
            System.out.println("accumulator:" + set + "， " + Thread.currentThread().getName());
        };
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
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher invoke");
        return set -> {
            Map<T, T> map = new TreeMap<>();
            set.stream().forEach(item -> map.put(item, item));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoke");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED, Characteristics.CONCURRENT));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {

        }
        List<String> list = Arrays.asList("hello", "world", "welcome", "a", "c", "b", "e");
//        Set<String> set = list.stream().collect(new MySetCollector<>());
        Set<String> set = new HashSet<>();
        set.addAll(list);
        Map<String, String> map = set.parallelStream().collect(new MySetToMapCollector<>());
        System.out.println(map);
    }
}
