package com.dtt.jdk8.stream;

import com.dtt.jdk8.bean.Student;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: dtt
 * @Date: 2019/6/18
 **/
public class CollectionTest {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 20);
        Student student2 = new Student("lisi", 20);
        Student student3 = new Student("wangwu", 30);
        Student student4 = new Student("zhangsan", 40);
        List<Student> list = Arrays.asList(student1, student2, student3, student4);

        //分组
        Map<Integer, List<Student>> map1 = list.stream().collect(Collectors.groupingBy(Student::getScore));
        //分组统计
        Map<Integer, Long> map2 = list.stream().collect(Collectors.groupingBy(Student::getScore, Collectors.counting()));
        //分组求平均
        Map<String, Double> map3 = list.stream().collect(Collectors.groupingBy(Student::getName,Collectors.averagingDouble(Student::getScore)));
        //分区只分为两个部分
        Map<Boolean, List<Student>> map4 = list.stream().collect(Collectors.partitioningBy(item->item.getScore()>30));

        System.out.println(map1);
        System.out.println(map2);
        System.out.println(map3);
        System.out.println(map4);

    }
}
