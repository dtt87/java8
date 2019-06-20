package com.dtt.jdk8.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("nihao", "hello", "world", "welcome");
//        list.stream().collect(Comparator.comparing((v1,v2)->{}));

        //字符串长度升序
        Collections.sort(list, (s1, s2) -> s1.length() - s2.length());
        //字符串长度降序
        Collections.sort(list, (s1, s2) -> s2.length() - s1.length());
        /*
        注意加上reversed()方法后 item的类型就推断不出来了，因为comparingInt(<? super T>) 参数可以为父类也就是Object
        所以需要对item进行强转为String
         */
        Collections.sort(list, Comparator.comparingInt((String item) -> item.length()).reversed());
        Collections.sort(list, Comparator.comparingInt(String::length).reversed().thenComparing(String::compareTo));

        list.sort(Comparator.naturalOrder());
        list.sort(Comparator.comparingInt(String::length).reversed());
        list.sort(Comparator.reverseOrder());


        //thenComparing()只有在前面的比较器返回0的时候才会调用
        Collections.sort(list, Comparator.comparingInt(String::length).thenComparing(String::compareToIgnoreCase));



        System.out.println(list);
    }
}
