package dev.Innocent.Section8.RegularExpression.MiniChallenge;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String sentence = "Hello, World";
        boolean matches = sentence.matches("Hello, World");
        System.out.println(matches);

        String challenge2 = "[A-Z].*\\.";
        for(String s : List.of("The bike is red.", "I am a new student.",
                "hello world.", "How are you")){
            boolean matched = s.matches(challenge2);
            System.out.println(matched + ": " + s);
        }

    }
}
