package dev.Innocent.Section7.Generics;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class miniLamdaChallenges {
    public static void main(String[] args) {
        Consumer<String> printWords = new Consumer<String>() {
            @Override
            public void accept(String sentence) {
                String[] parts = sentence.split(" ");
                for(String part : parts){
                    System.out.println(part);
                }
            }
        };

        Consumer<String> printWordsLambda = sentence -> {
            String[] parts = sentence.split(" ");
            for(String part : parts){
                System.out.println(part);
            }
        };

        printWords.accept("Let's split this up into an array");
        printWords.accept("Let's split this up into an array");

        Consumer<String> printWordsLambda2 = sentence -> {
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach(s -> System.out.println(s));
        };
        printWords.accept("Let's split this up into an array");

        Consumer<String> printWordsLambda3 = sentence -> {
            Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));
        };
        printWords.accept("Let's split this up into an array");

        // Convert "everySecondChar method to Lambda function"
//        Function<String, String> everySecondChar = source -> {
//            StringBuilder returnVal = new StringBuilder();
//            for(int i = 0; i < source.length(); i++){
//                if(i % 2 == 1){
//                    returnVal.append(source.charAt(i));
//                }
//            }
//            return returnVal.toString();
//        };

        // Convert "everySecondChar method to Lambda function 2"
        UnaryOperator<String> everySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i < source.length(); i++){
                if(i % 2 == 1){
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };
        System.out.println(everySecondChar.apply("123456789"));
    }

    public static String everySecondChar(String source){
        StringBuilder returnVal = new StringBuilder();
        for(int i = 0; i < source.length(); i++){
            if(i % 2 == 1){
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    public static String everySecondCharacter(Function<String, String> func, String source){
        return func.apply(source);
    }
}
