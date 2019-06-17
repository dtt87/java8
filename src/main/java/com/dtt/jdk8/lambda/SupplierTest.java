package com.dtt.jdk8.lambda;

import java.util.function.Supplier;

/**
 * @author: dtt
 * @Date: 2019/6/14
 **/
public class SupplierTest {
    public static void main(String[] args) {
        Supplier supplier = () -> "hello";
        System.out.println(supplier.get());
    }
}
