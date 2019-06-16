package com.dtt.jdk8.lambda;

import com.dtt.jdk8.bean.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PersonTest {

    public static void main(String[] args) {
        Person person1 = new Person("zhangsan",20);
        Person person2 = new Person("lisi",30);
        Person person3 = new Person("wangwu",40);

        List<Person> persons = Arrays.asList(person1, person2, person3);

        PersonTest personTest = new PersonTest();

        List<Person> personResult = personTest.getPersonByAge2(20, persons, (age, personList) -> personList.stream().filter(person -> person.getAge() > age).collect(Collectors.toList()));

        personResult.forEach(i -> System.out.println(i.getAge()));
    }

    private List<Person> getPersonByAge2(int age, List<Person> persons, BiFunction<Integer, List<Person>, List<Person>> biFunction) {
        return biFunction.apply(age, persons);
    }



}
