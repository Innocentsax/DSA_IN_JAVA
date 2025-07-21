package dev.Innocent.Section8.FileOperation.ManagingFiles;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File oldFile = new File("students.json");
        File newFile = new File("student-activity.json");

        if(oldFile.exists()){
            oldFile.renameTo(newFile);
            System.out.println("FIle renamed successfully");
        } else {
            System.out.println("File does not exist");
        }
    }
}
