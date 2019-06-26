package com.dtt.jdk8.stream;/**
 * Created by Lenovo on 2019/6/26.
 */

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * @author: dtt
 * @Date: 2019/6/26
 **/
public class OfIntTest {
    public static void main(String[] args){
        Consumer<Integer> consumer = (i)-> {
            i++;
            System.out.println(i);};
        IntConsumer intConsumer = (IntConsumer) consumer;
        ((IntConsumer) consumer).accept(2);
    }
}
