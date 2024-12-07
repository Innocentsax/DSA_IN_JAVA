package dev.Innocent.Section7.Generics;

import java.util.ArrayList;
import java.util.List;

public class StudentMain {
    public static void main(String[] args) {
        int studentCount = 20;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student());
        }
        students.add(new LPAStudent());
        printMMoreList(students);

        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());
        }
        printMMoreList(lpaStudents);
    }

    public static void printMMoreList(List<? extends Student> students){
        for(var student : students){
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }

    public static <T extends Student> void printList(List<T> students){
        for(var student : students){
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }
}
