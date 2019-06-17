package com.dtt.jdk8;

import java.util.function.Supplier;

/**
 * @author: dtt
 * @Date: 2019/6/14
 **/
public class StudentTest {

    public static void main(String[] args) {
        Supplier<Student> studentSupplier = () -> new Student();
        System.out.println(studentSupplier.get().getName());
        System.out.println("------------------");
        Supplier<Student> studentSupplier2 = Student::new;
        System.out.println(studentSupplier2.get().getName());
    }

}
