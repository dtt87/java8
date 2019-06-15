package com.dtt.jdk8;

import com.dtt.jdk8.bean.Company;
import com.dtt.jdk8.bean.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {

        /**
         * 判断对象是否为null
         */
        //创建对象
        Optional<String> optional = Optional.of("hello");
        //创建空对象
        Optional<String> optional2 = Optional.empty();

        //之前思想的写法，不推荐
        if (optional.isPresent()) {
            optional.get();
        }
        //正确写法，若存在
        optional.ifPresent(System.out::println);
        //若不存在
        optional2.orElse("world");
        System.out.println(optional2.orElseGet(() -> "nihao"));

        System.out.println("--------------");

        /**
         * 判断集合是否为null
         */
        Employee employee = new Employee("zhangsan");
        Employee employee2 = new Employee("lisi");

        List<Employee> employees = Arrays.asList(employee, employee2);
        Company company = new Company();
        company.setName("company");
//        company.setEmployees(employees);
        //构造optional容器
        Optional<Company> optionalCompany = Optional.ofNullable(company);
        //判断集合对象是否为空非常经典的写法
        List<Employee> res = optionalCompany.map(i -> i.getEmployees()).orElse(Collections.emptyList());

        System.out.println(res);


    }


}
