package dev.Innocent.Section8.StreamingStudents;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainCollect {
    public static void main(String[] args) {
        Course pymc= new Course("PYMC", "Python Masterclass");
        Course jmc= new Course("JMC", "Java Masterclass");

        List<Student> students =
                Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                        .limit(1000)
                        .toList();

        Set<Student> australiansStudent = students.stream()
                .filter((s) -> s.getCountryCode().equals("AU"))
                .collect(Collectors.toSet());

        System.out.println("# of Australians Students = " + australiansStudent.size());

        Set<Student> underThirty = students.stream()
                .filter((s) -> s.getAgeEnrolled() < 30)
                .collect(Collectors.toSet());

        System.out.println("# of Under Thirty Students = " + underThirty.size());

        Set<Student> youngAussies1 = new TreeSet<>(Comparator.comparing(Student::getStudentId));
        youngAussies1.addAll(australiansStudent);
        youngAussies1.retainAll(underThirty);
        youngAussies1.forEach((s) -> System.out.print(s.getStudentId() + " "));
        System.out.println();

        Set<Student> youngAussies2 = students.stream()
                .filter((s) -> s.getAgeEnrolled() < 30)
                .filter((s) -> s.getCountryCode().equals("AU"))
                .collect(() -> new TreeSet<>(Comparator.comparing(
                        Student::getStudentId)), TreeSet::add, TreeSet::addAll);

        youngAussies2.forEach((s) -> System.out.print(s.getStudentId() + " "));
        System.out.println();

        String countryList = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .reduce("", (r, v) -> r + " " + v);
        System.out.println("countryList = " + countryList);
    }
}
