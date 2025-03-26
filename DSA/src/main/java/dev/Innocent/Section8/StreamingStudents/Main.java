package dev.Innocent.Section8.StreamingStudents;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python MasterClass");
        Course jmc = new Course("JMC", "Java MasterClass");
//        Student tim = new Student("AU", 2019, 30, "M", true, jmc, pymc);
//        System.out.println(tim);
//
//        tim.watchLecture("JMC", 10, 5, 2019);
//        tim.watchLecture("PYMC", 7, 7, 2020);
//        System.out.println(tim);

        Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(10)
                .forEach(System.out::println);
    }
}
