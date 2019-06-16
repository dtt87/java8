package com.dtt.jdk8.lambda;

import com.dtt.jdk8.bean.Student;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceTest {

    public String getString(Supplier<String> supplier) {
        return supplier.get() + "test";
    }

    public String getString2(String str, Function<String, String> function){
        return function.apply(str);
    }

    public static void main(String[] args) {

        Student student1 = new Student("zhangsan", 10);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 50);
        Student student4 = new Student("zhao", 40);

        List<Student> list = Arrays.asList(student1, student2, student3, student4);

//        //传统Lambda
//        list.sort((s1, s2) -> Student.CompareStudentByScore(s1, s2));
//        list.forEach(System.out::println);
//
//        System.out.println("------------------------");
//
//        //静态方法引用
//        list.sort(Student::CompareStudentByScore);
//        list.sort(Student::CompareStudentByName);

        //实例方法引用
//        list.sort(new StudentComparator()::CompareStudentByScore);
//        list.forEach(i-> System.out.println(i.getScore()));
//        list.sort(new StudentComparator()::CompareStudentByName);
//        list.forEach(i-> System.out.println(i.getName()));

        //
        /**
         * 类调用实例方法引用
         * 相当于 list.sort((v1, v2)-> v1.CompareByScore(v2));
         * 方法的调用者是sort第一个参数，后面的参数作为CompareByScore方法的入参
         */
        list.sort(Student::CompareByScore);
        list.forEach(i -> System.out.println(i.getScore()));


        List<String> cities = Arrays.asList("beijing", "tianjin", "shanghai", "guangzhou");
        Collections.sort(cities, (city1, city2) -> city1.compareToIgnoreCase(city2));
        cities.sort(String::compareToIgnoreCase);


        MethodReferenceTest test = new MethodReferenceTest();
        test.getString(String::new);

        System.out.println(test.getString2("hello", String::new));
    }
}
