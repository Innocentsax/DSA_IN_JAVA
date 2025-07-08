package dev.Innocent.Section8.FileOperation.ReadingFilesChallenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("article.txt"))){
//            System.out.printf("%,d lines in file%n", br.lines().count());
            Pattern pattern = Pattern.compile("\\p{javaWhitespace}+");
//            System.out.printf("%,d words in file%n", br.lines()
////                    .flatMap(pattern::splitAsStream).count());
//                    .flatMap(l -> Arrays.stream(l.split(pattern.toString())))
//                    .count()
//            );

//            System.out.printf("%,d words in file%n", br.lines()
//                    .mapToLong(l -> l.split(pattern.toString()).length)
//                    .sum()
//            );

            List<String> excluded = List.of(
                    "grand", "canyon", "retrieved", "archived", "service", "original");
            var result = br.lines().flatMap(pattern::splitAsStream)
                    .map(w -> w.replaceAll("\\p{Punct}",""))
                    .filter(w -> w.length() > 4)
                    .map(String::toLowerCase)
                    .filter(w -> !excluded.contains(w))
                    .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

            result.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey,
                    Comparator.reverseOrder()))
                    .limit(10)
                    .forEach(e -> System.out.println(
                            e.getKey() + " - " + e.getValue() + " times"
                    ));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------------------------------------");
        String input = null;
            try {
                input = Files.readString(Path.of("article.txt"));
                input = input.replaceAll("\\p{Punct}", "");

                Pattern pattern = Pattern.compile("\\w{5,}");
                Matcher matcher = pattern.matcher(input);
                Map<String, Long> results = new HashMap<>();
                while (matcher.find()){
                    String word = matcher.group().toLowerCase();
                    if(word.length() > 4){
                        results.merge(word, 1L, (o, n) -> o += n);
                    }
                }

                var sortedEntries = new ArrayList<>(results.entrySet());
                sortedEntries.sort(Comparator.comparing(
                        Map.Entry::getKey, Comparator.reverseOrder()));
                for(int i = 0; i < Math.min(10, sortedEntries.size()); i++){
                    var entry = sortedEntries.get(i);
                    System.out.println(entry.getKey() + " - " + entry.getValue() + " times");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
