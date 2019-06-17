package com.dtt.jdk8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: dtt
 * @Date: 2019/6/14
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String name = "zhangsan";

    private int age = 20;

}
