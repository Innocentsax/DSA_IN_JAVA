package dev.Innocent.Section8.FileOperation.FileListings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path path = Path.of("");
        System.out.println("cwd = " + path.toAbsolutePath());

        try (Stream<Path> paths = Files.list(path)) {
            paths.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
