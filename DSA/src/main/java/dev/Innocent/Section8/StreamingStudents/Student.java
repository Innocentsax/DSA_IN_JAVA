package dev.Innocent.Section8.StreamingStudents;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class Student {
    private static long lastStudentId = 1;
    private final static Random random = new Random();
    private final long studentId;
    private final String countryCode;
    private final int yearEnrolled;
    private final int ageEnrolled;
    private final String gender;
    private final boolean programmingExperience;
    private final Map<String, CourseEngagement> engagementMap = new HashMap<>();

    public Student(String countryCode, int yearEnrolled, int ageEnrolled,
                   String gender, boolean programmingExperience, Course... courses) {
        studentId = lastStudentId++;
        this.countryCode = countryCode;
        this.yearEnrolled = yearEnrolled;
        this.ageEnrolled = ageEnrolled;
        this.gender = gender;
        this.programmingExperience = programmingExperience;

        for(Course course : courses){
            addCourse(course, LocalDate.of(yearEnrolled, 1, 1));
        }
    }

    public void addCourse(Course newCourse){
        addCourse(newCourse, LocalDate.now());
    }

    public void addCourse(Course newCourse, LocalDate enrollDate){
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
        return Map.copyOf(engagementMap);
    }

    public int getYearsSinceEnrolled(){
        return LocalDate.now().getYear() - yearEnrolled;
    }

    public int getAge(){
        return ageEnrolled + getYearsSinceEnrolled();
    }

    public int getMonthsSinceActive(String countryCode){
        CourseEngagement info = engagementMap.get(countryCode);
        return info == null ? 0 : info.getMonthsSinceActive();
    }

    public int getMonthsSinceActive(){
        int inactiveMonths = (LocalDate.now().getYear() - 2024) * 12;
        for(String key : engagementMap.keySet()){
            inactiveMonths = Math.min(inactiveMonths, getMonthsSinceActive(key));
        }
        return inactiveMonths;
    }

    public double getPercentComplete(String courseCode){
        var info = engagementMap.get(courseCode);
        return (info == null) ? 0 : info.getPercentComplete();
    }

    public void watchLecture(String courseCode, int lectureNumber, int month, int year){
        var activity = engagementMap.get(courseCode);
        if(activity != null){
            activity.watchLecture(lectureNumber, LocalDate.of(year, month, 1));
        }
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
