package dev.Innocent.Section8.Stream.StreamingStudents;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainChallenge {
    public static void main(String[] args) {
        Course pymc= new Course("PYMC", "Python Masterclass", 50);
        Course jmc= new Course("JMC", "Java Masterclass", 100);
        Course jgames = new Course("JGAME", "Creating games in Java");

        List<Student> student = Stream
                .iterate(1, s -> s <= 5000, s -> s + 1)
                .map(s -> Student.getRandomStudent(jmc, pymc))
                .toList();

        List<Student> student2 = IntStream
                .rangeClosed(1, 5000)
                .mapToObj(s -> Student.getRandomStudent(jmc, pymc))
                .toList();

        double totalPercent = student2.stream()
                .mapToDouble(s -> s.getPercentComplete("JMC"))
                .reduce(0, Double::sum);

        double avePercent = totalPercent / student2.size();
        System.out.printf("Average Percentage Complete = %.2f%% %n", avePercent);

        int topPercent = (int) (1.25 * avePercent);
        System.out.printf("Best Percentage Complete = %d%% %n", topPercent);

        Comparator<Student> longTermStudent = Comparator.comparing(Student::getYearEnrolled);

        List<Student> hardWorker = student2.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .sorted(longTermStudent)
                .limit(10)
                .toList();

        hardWorker.forEach(s -> {s.addCourse(jgames);
            System.out.print(s.getStudentId() + " ");
        });

        System.out.println();

        Comparator<Student> uniqueSorted = longTermStudent.thenComparing(Student::getStudentId);

        student2.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .sorted(longTermStudent)
                .limit(10)
//                .toList();
//                .collect(Collectors.toList())
//                .collect(Collectors.toSet())
                .collect(() -> new TreeSet<>(uniqueSorted), TreeSet::add, TreeSet::addAll)
                .forEach(s -> {s.addCourse(jgames);
                System.out.print(s.getStudentId() + " ");
        });
    }
}
