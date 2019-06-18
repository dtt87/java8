package com.dtt.jdk8.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class Student {
    private String name;
    private int score;

    public static int CompareStudentByScore(Student student1, Student student2) {
        return student1.getScore() - student2.getScore();
    }
    public static int CompareStudentByName(Student student1, Student student2) {
        return student1.getName().compareToIgnoreCase(student2.getName());
    }

    public int CompareByScore(Student student){
        return this.score - student.getScore();
    }
    public int CompareByName(Student student){
        return this.name.compareToIgnoreCase(student.getName());
    }

}
