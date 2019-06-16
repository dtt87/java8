package com.dtt.jdk8.stream;

import java.util.IntSummaryStatistics;
import java.util.UUID;
import java.util.stream.Stream;

public class Test6 {
    public static void main(String[] args) {
        //用supplier类型创建
        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
        stream.findFirst().ifPresent(System.out::println);
        System.out.println("-----------------");

        //初始值为seed，后面的元素是对前面的值进行迭代，生成无限的串行流
        Stream<Integer> stream1 = Stream.iterate(1, i -> i + 2).limit(6);

        /**
         * 找出大于2的元素，将每个元素*2，忽略前两个元素，然后在取出流的元素，求和
         * mapToInt避免了自动拆箱装箱的损耗
         * sum()返回int类型，Stream为空返回0就可以了
         * min()和max()返回optional，规避了空指针的异常
         */
        System.out.println(stream1.filter(i -> i > 2).mapToInt(i -> i * 2).skip(2).limit(2).sum());
        stream1.filter(i -> i > 2).mapToInt(i -> i * 2).skip(2).limit(2).min().ifPresent(System.out::println);

        //summaryStatistics可以对结果stream进行不同的计算操作
        IntSummaryStatistics summaryStatistics = stream1.filter(i -> i > 2)
                .mapToInt(i -> i * 2).skip(2).limit(2).summaryStatistics();
        summaryStatistics.getAverage();
        summaryStatistics.getMin();
        summaryStatistics.getMax();


    }
}
