package dev.Innocent.Section8.FileOperation.DirectoryFileChallenge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path deepestFile = Path.of("public", "assets", "icons");

        try {
            Files.createDirectories(deepestFile);
            generateIndexFile(deepestFile.getName(0));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(int i = 1; i <= deepestFile.getNameCount(); i++){
            Path indexedPath = deepestFile.subpath(0, i).resolve("index.txt");
            Path backupPath = deepestFile.subpath(0, i).resolve("indexCopy.txt");
            try {
                Files.copy(indexedPath, backupPath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try{
            generateIndexFile(deepestFile.getName(0));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void generateIndexFile(Path startingPath) throws IOException {
        Path indexFile = startingPath.resolve("index.txt");
        try (Stream<Path> contents = Files.find(startingPath, Integer.MAX_VALUE,
                (path, attr) -> true)){
            String fileContents = contents
                    .map((path) -> path.toAbsolutePath().toString())
                            .collect(Collectors.joining(
                                    System.lineSeparator(),
                                    "Directory Contents: " + System.lineSeparator(),
                                    System.lineSeparator() + "Generated: " + LocalDateTime.now()
                            ));
            Files.writeString(indexFile, fileContents, StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try(Stream<Path> contents = Files.list(startingPath)){
            contents.filter(Files::isDirectory)
                    .toList().forEach(dir -> {
                        try {
                            generateIndexFile(dir);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }
    }
}
