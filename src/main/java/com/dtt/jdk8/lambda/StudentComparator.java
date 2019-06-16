package com.dtt.jdk8.lambda;

import com.dtt.jdk8.bean.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentComparator {

    public int CompareStudentByScore(Student student1, Student student2) {
        return student1.getScore() - student2.getScore();
    }
    public int CompareStudentByName(Student student1, Student student2) {
        return student1.getName().compareToIgnoreCase(student2.getName());
    }
}
