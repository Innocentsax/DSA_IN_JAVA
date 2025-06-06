package dev.Innocent.Section8.FileOperation.FileAndPath;

import java.io.File;

public class Main {
    public static void main(String[] args) {

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
    }
}
