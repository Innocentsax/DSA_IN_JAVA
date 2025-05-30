package dev.Innocent.Section8.RegularExpression.MiniChallenge;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String sentence = "Hello, World";
        boolean matches = sentence.matches("Hello, World");
        System.out.println(matches);

        String challenge2 = "[A-Z][a-z\\s]+[.]";
        for(String s : List.of("The bike is red.", "I am a new student.",
                "hello world.", "How are you")){
            boolean matched = s.matches(challenge2);
            System.out.println(matched + ": " + s);
        }

        String challenge3 = "[A-Z][a-z\\s]+[.]";
        for(String s : List.of("The bike is red, and has flat tires",
                "I love being a new L.P.A. student",
                "Hello, friends and family: Welcome!", "How are you, Mary?")){
            boolean matched = s.matches(challenge3);
            System.out.println(matched + ": " + s);
        }
    }
}
