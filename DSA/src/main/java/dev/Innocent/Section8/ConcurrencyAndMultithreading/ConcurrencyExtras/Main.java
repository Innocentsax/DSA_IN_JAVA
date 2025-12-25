package dev.Innocent.Section8.ConcurrencyAndMultithreading.ConcurrencyExtras;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.*;

record Student(String name, int enrolledYear, int studentId)
    implements Comparable<Student>{


    @Override
    public int compareTo(Student o) {
        return this.studentId - o.studentId;
    }
}

class StudentId{
    private int id = 0;
    public int getId(){
        return id;
    }
    public synchronized int getNextId(){
        return ++id;
    }
}

public class Main {
    private static Random random = new Random();

    private static ConcurrentSkipListSet<Student> studentSet = new ConcurrentSkipListSet<>();

    public static void main(String[] args) {
        StudentId idGenerator = new StudentId();
        Callable<Student> studentMaker = () -> {
            int studentId = idGenerator.getNextId();
            Student student = new Student("Udo " + studentId, random.nextInt(2018, 2025), studentId);
            studentSet.add(student);
            return student;
        };

        var executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            studentSet.clear();
            try {
                var futures = executor.invokeAll(Collections.nCopies(10, studentMaker));
                System.out.println("# of students = " + studentSet.size());
//                studentSet.forEach(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        executor.shutdown();
    }
}
