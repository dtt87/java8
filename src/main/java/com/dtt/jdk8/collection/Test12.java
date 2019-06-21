package com.dtt.jdk8.collection;

import com.dtt.jdk8.bean.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

/**
 * @author: dtt
 * @Date: 2019/6/18
 **/
public class Test12 {
    public static void main(String[] args){
        Student student1 = new Student("zhangsan", 80);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 100);
        Student student4 = new Student("zhaoliu", 90);

        List<Student> list = Arrays.asList(student1, student2, student3, student4);

        System.out.println(list.stream().collect(Collectors.counting()));
        System.out.println(list.stream().count());
        System.out.println("-------------------");
        list.stream().collect(minBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::print);
        list.stream().collect(maxBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::print);

        list.stream().collect(averagingInt(Student::getScore));
    }
}
