package dev.Innocent.Section8.StreamingStudents;

import java.util.Random;

public class Student {
    private static long lastStudentId = 1;
    private final static Random random = new Random();
    private final long studentId;
    private final String countryCode;
    private final int yearEnrolled;
    private final int ageEnrolled;
    private final String gender;
}
