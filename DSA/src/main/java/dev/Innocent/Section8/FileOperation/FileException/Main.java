package dev.Innocent.Section8.FileOperation.FileException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Current working Directory CWD: " + new File("").getAbsolutePath());
        String filename = "files/testing.csv";
        File file = new File(filename);

        if(!file.exists()){
            System.out.println("I can't run unless this file exists");
            return;
        }
        System.out.println("I'm good to go");

        // An Unchecked exception is an instance of a RuntimeException or one of it's subclasses
    }

    private static void testFile(String filename){
        Path path = Paths.get(filename);
        FileReader reader = null;
        // The IOException is a special kind of exception, called a Checked Exception
        try {
//            List<String> lines = Files.readAllLines(path);
            reader = new FileReader(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Maybe I'd log something either way...");
        }
        System.out.println("File exists and able to use as a resource");
    }

    private static void testFile2(String filename){
        try (FileReader reader = new FileReader(filename)) {
        } catch (FileNotFoundException e) {
            System.out.println("File '" + filename + "' does not exist");
            throw new RuntimeException(e);
        } catch (NullPointerException | IllegalArgumentException badData) {
            System.out.println("User has added bad data "  + badData.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Something unrelated and unexpected happened");
        }finally {
            System.out.println("Maybe I'd log something either way...");
        }
    }
}
