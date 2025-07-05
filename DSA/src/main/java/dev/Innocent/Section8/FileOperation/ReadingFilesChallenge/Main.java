package dev.Innocent.Section8.FileOperation.ReadingFilesChallenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("article.txt"))){
//            System.out.printf("%,d lines in file%n", br.lines().count());
            Pattern pattern = Pattern.compile("\\p{javaWhitespace}+");
            System.out.printf("%,d words in file%n", br.lines()
                    .flatMap(pattern::splitAsStream).count());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
