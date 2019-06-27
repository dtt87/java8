package com.dtt.jdk8.stream;/**
 * Created by Lenovo on 2019/6/26.
 */

import java.util.Tripwire;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * @author: dtt
 * @Date: 2019/6/26
 **/
public class OfIntTest {
    public void test(Consumer<? super Integer> consumer){
//        consumer.accept(100);
        if (consumer instanceof IntConsumer){
            System.out.println("is instance");
            test((IntConsumer)consumer);
        } else {
        }

    }

    /**
     * 源代码不知道为啥编译不通过
     * @param action
     * @return
     */
    boolean tryAdvance(Consumer<? super Integer> action) {
        if (action instanceof IntConsumer) {
            return tryAdvance((IntConsumer) action);
        }
        else {
            return tryAdvance((IntConsumer) action::accept);
        }
    }
    public static void main(String[] args){
        Consumer<Integer> consumer = (i)-> {
            i++;
            System.out.println(i);};
        IntConsumer intConsumer = (i)-> {
            i--;
            System.out.println(i);};;
         OfIntTest ofIntTest = new OfIntTest();
//         ofIntTest.test(consumer); //传统的传对象
//         ofIntTest.test(consumer::accept); //传递lambda表达式行为
         ofIntTest.test(intConsumer::accept); //把intConsumer型的表达式传递进去了
    }
}
