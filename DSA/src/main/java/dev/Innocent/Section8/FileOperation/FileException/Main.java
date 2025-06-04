package dev.Innocent.Section8.FileOperation.FileException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filename = "testing.csv";

        testFile(filename);
        File file = new File(filename);
        if(!file.exists()){
            System.out.println("I can't run unless this file exists");
            System.out.println("Quitting Application, go figure it out");
            return;
        }
        System.out.println("I'm good to go");

        // An Unchecked exception is an instance of a RuntimeException or one of it's subclasses
    }

    private static void testFile(String filename){
        Path path = Paths.get(filename);

        // The IOException is a special kind of exception, called a Checked Exception
        try {
            List<String> lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Maybe I'd log something either way...");
        }
        System.out.println("File exists and able to use as a resource");
    }
}
