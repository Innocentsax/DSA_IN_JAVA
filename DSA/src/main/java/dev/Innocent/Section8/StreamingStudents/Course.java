package dev.Innocent.Section8.StreamingStudents;

public record Course(String courseCode, String title, int lectureCount) {

    public Course {
        if(lectureCount <= 0){
            lectureCount = 1;
        }
    }

    public Course(String courseCode, String title) {
        this(courseCode, title, 0);
    }

    @Override
    public String toString() {
        return "%s %s".formatted(courseCode, title);
    }
}
