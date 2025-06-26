package dev.Innocent.Section8.FileOperation.FileWalker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ChallengeStream {
    public static void main(String[] args) {

        Path startingPath = Path.of("..");
        int index = startingPath.getNameCount();
        try (var paths = Files.walk(startingPath, Integer.MAX_VALUE)) {
            paths
                    .filter(Files::isRegularFile)
                    .collect(Collectors.groupingBy(p -> p.subpath(index, index + 1),
                            Collectors.summarizingLong(
                                    p -> p.toFile().length())))
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparing(e -> e.getKey().toString()))
                    .filter(e -> e.getValue().getSum() > 50_000)
                    .forEach(e -> {
                        System.out.printf("[%s] %,d bytes, %d files %n",
                                e.getKey(), e.getValue().getSum(),
                                e.getValue().getCount());
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
