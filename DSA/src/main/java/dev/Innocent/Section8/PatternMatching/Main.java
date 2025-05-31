package dev.Innocent.Section8.PatternMatching;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String sentence = "I like motorcycles.";
        boolean matched = Pattern.matches("[A-Z].*[.]", sentence);
        System.out.println(matched + ": " + sentence);

        Pattern firstPattern  = Pattern.compile("[A-Z].*[.]");
        var matcher = firstPattern.matcher(sentence);
        System.out.println(matcher.matches() + ": " +sentence);
    }
}
