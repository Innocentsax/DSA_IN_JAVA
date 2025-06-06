package dev.Innocent.Section8.FileOperation.FileAndPath;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        useFile("testfile.txt");
    }

    private static void useFile(String fileName){
        File file = new File(fileName);
        boolean fileExists = file.exists();

        System.out.printf("File '%s' %s%n", fileName,
                fileExists ? "exists." : "does not exist.");

        if(fileExists){
            System.out.println("Deleting File: " + fileName);
            fileExists = !file.delete();
        }

        if(!fileExists){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
            System.out.println("Create File: " + fileName);
            if(file.canWrite()){
                System.out.println("Would write to file here");
            }
        }
    }
}
