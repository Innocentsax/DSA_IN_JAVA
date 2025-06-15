package dev.Innocent.Section8.FileOperation.PathListings;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Path path = Path.of("files/come.txt");
        printPathInfo(path);
        logStatement(path);
    }

    private static void printPathInfo(Path path){
        System.out.println("Path: " + path);
        System.out.println("fileName = " + path.getFileName());
        System.out.println("parent = " + path.getParent());
        Path absolutePath = path.toAbsolutePath();
        System.out.println("Absolute Path: = " + absolutePath);
        System.out.println("Absolute Path Root: = " + absolutePath.getRoot());
        System.out.println("Root = " + path.getRoot());
        System.out.println("isAbsolute = " + path.isAbsolute());
        System.out.println("--------------------------------------");

//        System.out.println(absolutePath.getRoot());
//        int i = 1;
//        var it = path.toAbsolutePath().iterator();
//        while(it.hasNext()){
//            System.out.println(".".repeat(i++) + " " + it.next());
//        }

        int pathParts = absolutePath.getNameCount();
        for(int i = 0; i < pathParts; i++){
            System.out.println(".".repeat(i + 1) + " " + absolutePath.getName(i));
        }
        System.out.println("-------------------------------------------");
    }

    public static void logStatement(Path path){
        try{
            Path parent = path.getParent();
            if(!Files.exists(parent)){
                Files.createDirectory(parent);
            }
            Files.writeString(path, Instant.now() + ": hello file world\n",
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
