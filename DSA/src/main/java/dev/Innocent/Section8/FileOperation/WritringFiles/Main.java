package dev.Innocent.Section8.FileOperation.WritringFiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        String header = """
                Student Id,Country Code,Enrolled Year,Age,Gender,\
                Experienced,Course Code,Engagement Month,Engagement Year,\
                Engagement Type""";

        Course jmc = new Course("JMC", "Java Masterclass");
        Course pymc = new Course("PYC", "Python Masterclass");
        List<Student> students = Stream
                .generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(25)
                .toList();

//        System.out.println(header);
//        students.forEach(s -> s.getEngagementRecords().forEach(System.out::println));

        Path path = Path.of("students.csv");
//        try {
//            Files.writeString(path, header);
//            for (Student student : students) {
//                Files.write(path, student.getEngagementRecords(),
//                        StandardOpenOption.APPEND);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            List<String> data = new ArrayList<>();
//            data.add(header);
//            for (Student student : students) {
//                data.addAll(student.getEngagementRecords());
//            }
//            Files.write(path, data);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try (BufferedWriter writer =
                     Files.newBufferedWriter(Path.of("take2.csv"))) {
            writer.write(header);
            writer.newLine();
            int count = 0;
            for (Student student : students) {
                for (var record : student.getEngagementRecords()) {
                    writer.write(record);
                    writer.newLine();
                    count++;
                    if (count % 5 == 0) {
                        Thread.sleep(2000);
                        System.out.print(".");
                    }
                    if (count % 10 == 0) {
                        writer.flush();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter writer =
                     new FileWriter("take3.csv")) {
            writer.write(header);
            writer.write(System.lineSeparator());
            for (Student student : students) {
                for (var record : student.getEngagementRecords()) {
                    writer.write(record);
                    writer.write(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter writer =
                     new PrintWriter("take4.txt")) {
            writer.println(header);
            for (Student student : students) {
                for (var record : student.getEngagementRecords()) {
                    String[] recordData = record.split(",");
                    writer.printf("%-12d%-5s%2d%4d%3d%-1s".formatted(
                            student.getStudentId(),  // Student Id
                            student.getCountry(),  // Country Code
                            student.getEnrollmentYear(),  // Enrolled Year
                            student.getEnrollmentMonth(),  // Enrolled Month
                            student.getEnrollmentAge(),  // Age
                            student.getGender()));  // Gender
                    writer.printf("%-1s",
                            (student.hasExperience() ? 'Y' : 'N'));  // Experienced?
                    writer.format("%-3s%10.2f%-10s%-4s%-30s",
                            recordData[7],  // Course Code
                            student.getPercentComplete(recordData[7]),
                            recordData[8],  // Engagement Month
                            recordData[9],  // Engagement Year
                            recordData[10]);  // Engagement Type
                    writer.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
