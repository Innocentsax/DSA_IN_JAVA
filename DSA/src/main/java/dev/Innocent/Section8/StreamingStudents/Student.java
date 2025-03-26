package dev.Innocent.Section8.StreamingStudents;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import java.util.*;

public class Student {
    private static long lastStudentId = 1;
    private static final Random random = new Random();

    private final long studentId;
    private final String countryCode;
    private final int yearEnrolled;
    private final int ageEnrolled;
    private final String gender;
    private final boolean programmingExperience;
    private final Map<String, CourseEngagement> engagementMap = new HashMap<>();

    public Student(String countryCode, int yearEnrolled, int ageEnrolled,
                   String gender, boolean programmingExperience, Course... courses) {
        this.studentId = lastStudentId++;
        this.countryCode = countryCode;
        this.yearEnrolled = yearEnrolled;
        this.ageEnrolled = ageEnrolled;
        this.gender = gender;
        this.programmingExperience = programmingExperience;

        for (Course course : courses) {
            addCourse(course, LocalDate.of(yearEnrolled, 1, 1));
        }
    }

    public void addCourse(Course newCourse) {
        addCourse(newCourse, LocalDate.now());
    }

    public void addCourse(Course newCourse, LocalDate enrollDate) {
        engagementMap.put(newCourse.courseCode(), new CourseEngagement(
                newCourse, enrollDate, "Enrollment"));
    }

    public long getStudentId() {
        return studentId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public int getYearEnrolled() {
        return yearEnrolled;
    }

    public int getAgeEnrolled() {
        return ageEnrolled;
    }

    public String getGender() {
        return gender;
    }

    public boolean hasProgrammingExperience() {
        return programmingExperience;
    }

    public Map<String, CourseEngagement> getEngagementMap() {
        return Collections.unmodifiableMap(engagementMap);
    }

    public int getYearsSinceEnrolled() {
        return LocalDate.now().getYear() - yearEnrolled;
    }

    public int getAge() {
        return ageEnrolled + getYearsSinceEnrolled();
    }

    public int getMonthsSinceActive(String courseCode) {
        return Optional.ofNullable(engagementMap.get(courseCode))
                .map(CourseEngagement::getMonthsSinceActive)
                .orElse(0);
    }

    public int getMonthsSinceActive() {
        return engagementMap.values().stream()
                .mapToInt(CourseEngagement::getMonthsSinceActive)
                .min()
                .orElse(0);
    }

    public double getPercentComplete(String courseCode) {
        return Optional.ofNullable(engagementMap.get(courseCode))
                .map(CourseEngagement::getPercentComplete)
                .orElse(0.0);
    }

    public void watchLecture(String courseCode, int lectureNumber, int month, int year) {
        Optional.ofNullable(engagementMap.get(courseCode))
                .ifPresent(activity -> activity.watchLecture(lectureNumber, LocalDate.of(year, month, 1)));
    }

    private static String getRandomVal(String... data) {
        return data[random.nextInt(data.length)];
    }

    public static Student getRandomStudent(Course... courses) {
        int currentYear = LocalDate.now().getYear();
        int maxYear = currentYear + 1;

        String countryCode = getRandomVal("AU", "CA", "CN", "GB", "IN", "UA", "US");
        int yearEnrolled = random.nextInt(2025, maxYear);
        int ageEnrolled = random.nextInt(18, 90);
        String gender = getRandomVal("M", "F", "U");
        boolean programmingExperience = random.nextBoolean();

        Student student = new Student(countryCode, yearEnrolled, ageEnrolled, gender, programmingExperience, courses);

        for (Course c : courses) {
            int lecture = random.nextInt(1, c.lectureCount());
            int minYear = student.getYearEnrolled();
            int year = (minYear < maxYear) ? random.nextInt(minYear, maxYear) : minYear;
            int month = random.nextInt(1, 13);

            if (year == (maxYear - 1) && month > LocalDate.now().getMonthValue()) {
                month = LocalDate.now().getMonthValue();
            }

            student.watchLecture(c.courseCode(), lecture, month, year);
        }
        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", countryCode='" + countryCode + '\'' +
                ", yearEnrolled=" + yearEnrolled +
                ", ageEnrolled=" + ageEnrolled +
                ", gender='" + gender + '\'' +
                ", programmingExperience=" + programmingExperience +
                ", engagementMap=" + engagementMap +
                '}';
    }
}
