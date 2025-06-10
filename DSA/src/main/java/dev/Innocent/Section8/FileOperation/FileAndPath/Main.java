package dev.Innocent.Section8.FileOperation.FileAndPath;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        usePath2("testfile.txt");
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

    private static void usePath2(String fileName){
        Path path = Path.of(fileName);
        boolean fileExists = Files.exists(path);

        System.out.printf("File '%s' %s%n", fileName,
                fileExists ? "exists." : "does not exist.");

        if(fileExists){
            System.out.println("Deleting File: " + fileName);
            try {
                Files.delete(path);
                fileExists = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(!fileExists){
            try {
                Files.createFile(path);
            System.out.println("Create File: " + fileName);
            if(Files.isWritable(path)){
                Files.writeString(path, """
                        Here is somme data,
                        for my file,
                        just to prove,
                        Using the Files class and path are better!
                        """);

            }
                System.out.println("And I can read too");
                System.out.println("--------------------------------");
                Files.readAllLines(path).forEach(System.out::println);
            if(Files.isWritable(path)){
                System.out.println("Would write to file here");
            }            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
        }
    }
}
