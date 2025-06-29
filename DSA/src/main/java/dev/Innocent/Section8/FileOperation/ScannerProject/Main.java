package dev.Innocent.Section8.FileOperation.ScannerProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new File("file.txt"))){
//            while(scanner.hasNextLine()){
//                System.out.println(scanner.nextLine());
//            }
            System.out.println(scanner.delimiter());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
