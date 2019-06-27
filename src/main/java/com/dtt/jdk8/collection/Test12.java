package com.dtt.jdk8.collection;

import com.dtt.jdk8.bean.Student;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author: dtt
 * @Date: 2019/6/18
 **/
public class Test12 {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 80);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 100);
        Student student4 = new Student("zhaoliu", 90);
        Student student5 = new Student("zhaoliu", 90);

        List<Student> list = Arrays.asList(student1, student2, student3, student4, student5);

        System.out.println(list.stream().collect(Collectors.counting()));
        System.out.println(list.stream().count());

        //分组并计算各组的所有计算方式结果
        Map<Integer, IntSummaryStatistics> intSummaryStatistics = list.stream().collect(groupingBy(Student::getScore, summarizingInt(Student::getScore)));
        System.out.println(intSummaryStatistics);
        //多级分组
        Map<Integer, Map<String, List<Student>>> map = list.stream()
                .collect(Collectors.groupingBy(Student::getScore, groupingBy(Student::getName)));
        //多级分区
        Map<Boolean, Map<Boolean, List<Student>>> map2 = list.stream()
                .collect(partitioningBy(student -> student.getScore() > 80, partitioningBy(item -> item.getScore() > 90)));

        //
        Map<String, Optional<Student>> map3 = list.stream().collect(groupingBy(Student::getName, minBy(Comparator.comparingInt(Student::getScore))));
        //optional一定是有值的，所以直接用collectingAndThen取出值即可
        Map<String, Student> map4 = list.stream()
                .collect(groupingBy(Student::getName, collectingAndThen(
                        minBy(Comparator.comparingInt(Student::getScore)), Optional::get)));


        System.out.println(map4);
    }
}
