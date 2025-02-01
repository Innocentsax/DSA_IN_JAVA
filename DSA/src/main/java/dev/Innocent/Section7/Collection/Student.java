package dev.Innocent.Section7.Collection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

record Course(String courseId, String name, String subject){}

record Purchase(String courseId, int studentId, double price, int yr, int dayOfYear){
    public LocalDate purchaseDate(){
        return LocalDate.ofYearDay(yr, dayOfYear);
    }
}

public class Student {
    private static int lastId = 1;
    private String name;
    private int id;
    private List<Course> courseList;

    public Student(String name, List<Course> courseList) {
        this.name = name;
        this.courseList = courseList;
        id = lastId++;
    }

    public Student(String name, Course course) {
        this(name, new ArrayList<>(List.of(course)));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course course){
        courseList.add(course);
    }

    @Override
    public String toString() {
        String[] courseNames = new String[courseList.size()];
        Arrays.setAll(courseNames, i -> courseList.get(i).name());
        return "[%d] : %s".formatted(id, String.join(", ", courseNames));
    }
}
