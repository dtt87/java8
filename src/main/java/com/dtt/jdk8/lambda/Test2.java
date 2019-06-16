package com.dtt.jdk8.lambda;

public class Test2{

    public void myTest(MyInterface myInterface){
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.myTest(new MyInterface() {
            @Override
            public void test() {
                System.out.println("mytest");
            }
        });
        System.out.println("-------------");
        test2.myTest(() -> {
            System.out.println("test");
        });

        System.out.println("-------------");

        MyInterface myInterface = ()-> {

        };

        System.out.println(myInterface.getClass());

        System.out.println(myInterface.getClass().getSuperclass());
        System.out.println(myInterface.getClass().getInterfaces()[0]);

    }

}

@FunctionalInterface
interface MyInterface {

    //抽象方法
    void test();

    //Object里的方法不算抽象方法
    String toString();

    //默认实现方法
    default void test2(){
        System.out.println(1);
    }

    //静态方法
    static void test3(){
        System.out.println("2");
    }

}

