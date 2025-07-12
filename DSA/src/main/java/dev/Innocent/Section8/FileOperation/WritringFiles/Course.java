package dev.Innocent.Section8.FileOperation.WritringFiles;

public record Course(String courseCode, String title) {

    public int getLectureCount() {
        return 15;
    }

    @Override
    public String toString() {
        return "%s %s".formatted(courseCode, title);
    }
}