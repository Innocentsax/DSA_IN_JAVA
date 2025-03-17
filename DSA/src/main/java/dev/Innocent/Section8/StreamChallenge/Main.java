package dev.Innocent.Section8.StreamChallenge;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        int seed = 1;
        var streamB = Stream.iterate(seed, i -> i <= 15, i -> i + 1)
                .map(i -> "B" + i);
        streamB.forEach(System.out::println);
    }
}
