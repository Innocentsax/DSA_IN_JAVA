package dev.Innocent.Section7.Generics;

import java.util.function.Consumer;

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
    }
}
