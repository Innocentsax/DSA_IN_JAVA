package dev.Innocent.Section8.StreamingStudents;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MainTerminalOptional {
    public static void main(String[] args) {
        Course pymc= new Course("PYMC", "Python Masterclass");
        Course jmc= new Course("JMC", "Java Masterclass");

        List<Student> students =
                Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                        .limit(1000)
                        .toList();

        int minAge = 21;
        students.stream().filter(s -> s.getAge() <= minAge)
                .findAny()
                .ifPresentOrElse(s -> System.out.printf("Student %d from %s is %d%n",
                        s.getStudentId(), s.getCountryCode(), s.getAge()),
                        () -> System.out.println("Didn't find anyone under " + minAge));

        students.stream().filter(s -> s.getAge() <= minAge)
                .findFirst()
                .ifPresentOrElse(s -> System.out.printf("Student %d from %s is %d%n",
                                s.getStudentId(), s.getCountryCode(), s.getAge()),
                        () -> System.out.println("Didn't find anyone under " + minAge));

        students.stream().filter(s -> s.getAge() <= minAge)
                .min(Comparator.comparing(Student::getAge))
                .ifPresentOrElse(s -> System.out.printf("Student %d from %s is %d%n",
                                s.getStudentId(), s.getCountryCode(), s.getAge()),
                        () -> System.out.println("Didn't find anyone under " + minAge));

        students.stream().filter(s -> s.getAge() <= minAge)
                .max(Comparator.comparing(Student::getAge))
                .ifPresentOrElse(s -> System.out.printf("Student %d from %s is %d%n",
                                s.getStudentId(), s.getCountryCode(), s.getAge()),
                        () -> System.out.println("Didn't find anyone under " + minAge));

        students.stream().filter(s -> s.getAge() <= minAge)
                .mapToInt(Student::getAge)
                .average()
                .ifPresentOrElse(a -> System.out.printf("Avg age under 21: %.2f%n", a),
                        () -> System.out.println("Didn't find anyone under " + minAge));
    }
}
