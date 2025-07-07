package dev.Innocent.Section8.FileOperation.ReadingFilesChallenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
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

            var result = br.lines().flatMap(pattern::splitAsStream)
                    .map(w -> w.replaceAll("\\p{Punct}",""))
                    .filter(w -> w.length() > 4)
                    .map(String::toLowerCase)
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
    }
}
