package dev.Innocent.Section8.FileOperation.WritringFiles;

import java.time.LocalDate;
import java.util.*;

public class Student {

    private static long lastStudentId = 1;

    private final long studentId;
    private final StudentDemographics demographics;
    private final List<Course> coursesEnrolled;

    private final Map<String, CourseEngagement> engagementMap;

    public Student(String country, int month, int year, int age, String gender,
                   boolean hasExperience, Course... courses) {

        studentId = lastStudentId++;
        demographics = new StudentDemographics(country, month, year, age, gender,
                hasExperience);

        coursesEnrolled = new ArrayList<>(Arrays.asList(courses));
        engagementMap = new HashMap<>();

        for (Course course : courses) {
            engagementMap.put(course.courseCode(),
                    new CourseEngagement(course.courseCode(), month, year,
                            "Enrollment"));
        }
    }

    public long getStudentId() {
        return studentId;
    }

    public int getAge() {

        int currentYear = LocalDate.now().getYear();
        int enrolledYear = demographics.enrolledYear();
        int age = demographics.ageAtEnrollment();
        return age + (currentYear - enrolledYear);
    }

    public int getEnrollmentAge() {
        return demographics.ageAtEnrollment();
    }
    public String getGender() {
        return demographics.gender();
    }
    public int getEnrollmentYear() {
        return demographics.enrolledYear();
    }

    public int getEnrollmentMonth() {
        return demographics.enrolledMonth();
    }
    public String getCountry() {
        return demographics.countryCode();
    }

    public boolean hasExperience() {
        return demographics.previousProgrammingExperience();
    }

    public int getInactiveMonths(String courseCode) {

        CourseEngagement info = engagementMap.get(courseCode);
        return info.getInactiveMonths();
    }

    public int getInactiveMonths() {

        int inactiveMonths = 300;  // 25 years
        for (String key : engagementMap.keySet()) {
            int mos = getInactiveMonths(key);
            if  (mos < inactiveMonths) {
                inactiveMonths = mos;
            }
        }
        return inactiveMonths;
    }

    public double getPercentComplete(String courseCode) {

        var info = engagementMap.get(courseCode);

        for (var c : coursesEnrolled) {
            if (c.courseCode().equals(courseCode)) {
                return info.getPercentComplete(c.getLectureCount());
            }
        }
        System.out.println("Could not find " + courseCode);
        return 0;
    }

    public void addCourse(Course newCourse) {

        LocalDate now = LocalDate.now();
        engagementMap.put(newCourse.courseCode(),
                new CourseEngagement(newCourse.courseCode(), now.getMonthValue(),
                        now.getYear(), "Enrollment"));
        coursesEnrolled.add(newCourse);
    }

    public void startVideo(String courseCode, int lectureNumber, int month, int year) {

        var activity = engagementMap.get(courseCode);
        activity.recordLastActivity(lectureNumber, month, year);
    }

    @Override
    public String toString() {

        String engagementData = "";
        for (var engagement : engagementMap.values()) {
            engagementData += engagement.toString();
        }
        return "Student = %s %n%s%nCourses: %s%n%s".formatted(
                studentId, demographics, coursesEnrolled, engagementData);
    }

    public List<String> getEngagementRecords() {

        int i = 0;
        List<String> engagementData = new ArrayList<>();
        for (var engagement : engagementMap.values()) {
            engagementData.add("%s,%s,%s".formatted(
                    studentId,
                    demographics,
                    engagement));
        }
        return engagementData;
    }

    public String JSON() {
        return new StringJoiner(", ", "{", "}")
                .add("\"studentId\":" + studentId)
                .add("\"demographics\":" + demographics)
                .add("\"coursesEnrolled\":" + coursesEnrolled)
                .add("\"engagementMap\":" + engagementMap)
                .toString();
    }

    public static Student getRandomStudent(Course... courses) {

        Random random = new Random();
        String countryCode = List.of("AU", "CN", "GB", "IN","US")
                .get(random.nextInt(5));
        String gender = List.of("M", "F", "U").get(random.nextInt(3));

        int minYear = 2015;
        int maxYear = LocalDate.now().getYear() + 1;
        Student student = new Student(countryCode,
                random.nextInt(1, 13),
                random.nextInt(minYear, maxYear),
                random.nextInt(18, 90),
                gender, random.nextBoolean(), courses);

        int yearEnrolled = student.getEnrollmentYear();



        List.of(courses).forEach(c ->
                student.startVideo(c.courseCode(),
                        random.nextInt(1, c.getLectureCount()),
                        random.nextInt(1, 13),
                        random.nextInt(yearEnrolled, maxYear))
        );

        return student;
    }


}
