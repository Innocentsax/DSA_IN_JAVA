package dev.Innocent.Section8.FileOperation.ManagingFiles;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String[] args) {
//        File oldFile = new File("students.json");
//        File newFile = new File("student-activity.json");
//
//        if(oldFile.exists()){
//            oldFile.renameTo(newFile);
//            System.out.println("FIle renamed successfully");
//        } else {
//            System.out.println("File does not exist");
//        }
//
//        Path oldPath = oldFile.toPath();
//        Path newPath = newFile.toPath();
//
//        try{
//            Files.move(newPath, oldPath);
//            System.out.println("Path renamed successfully");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Path oldPath = Path.of("students.json");
//        Path newPath = Path.of("file/student-activity.json");
//
//        try{
//            Files.createDirectories(newPath.subpath(0, newPath.getNameCount() - 1));
//            Files.move(oldPath, newPath);
//            System.out.println(oldPath + " moved (renamed to) --> " + newPath);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        Path fileDir = Path.of("file");
//        Path resourceDir = Path.of("resources");
//
//        try{
//            recurseDelete(resourceDir);
//            recurseCopy(fileDir, resourceDir);
//            System.out.println("Directory copied to " + resourceDir);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try (BufferedReader reader = new BufferedReader(
//                new FileReader("files//student-activity.json"));
//             PrintWriter writer = new PrintWriter("students-backup.json")){
//            reader.transferTo(writer);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        String urlString = "https://api.census.gov/data/2019/pep/charagegroups?get=NAME,POP&for=state:*";
        URI uri = URI.create(urlString);
        try(var urlInputStream = uri.toURL().openStream();){
            urlInputStream.transferTo(System.out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void recurseCopy(Path source, Path target) throws IOException {
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        if(Files.isDirectory(source)){
            try (var children = Files.list(source)){
                children.toList().forEach(
                        p -> {
                            try {
                                Main.recurseCopy(
                                        p, target.resolve(p.getFileName())
                                );
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
            }
        }
    }

    public static void recurseDelete(Path target) throws IOException {
        if(Files.isDirectory(target)){
            try (var children = Files.list(target)){
                children.toList().forEach(
                        p -> {
                            try {
                                Main.recurseDelete(p);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
            }
            Files.delete(target);
        }
    }
}
