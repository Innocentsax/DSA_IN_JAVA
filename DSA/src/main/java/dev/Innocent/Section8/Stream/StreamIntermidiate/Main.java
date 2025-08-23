package dev.Innocent.Section8.Stream.StreamIntermidiate;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        IntStream.iterate((int) 'A', i -> i <= (int) 'z', i -> i + 1)
                .filter(Character::isAlphabetic)
                .distinct()
//                .dropWhile(i -> Character.toUpperCase(i) <= 'E')
//                .takeWhile(i -> i < 'a')
//                .skip(5)
//                .filter(i -> Character.toUpperCase(i) > 'E')
                .forEach(d -> System.out.printf("%c ", + d));

        System.out.println();
        Random random = new Random();

        Stream.generate(() -> random.nextInt((int) 'A', (int) 'Z' + 1))
                .limit(50)
                .distinct()
                .sorted()
                .forEach(d -> System.out.printf("%c ", d));

        System.out.println();
        int maxSeats = 100;
        int seatsInRow = 10;
        var stream = Stream.iterate(0, i -> i < maxSeats, i -> i + 1)
                .map(i -> new Seat((char) ('A' + i / seatsInRow),
                        i % seatsInRow + 1))
                .skip(5)
                .limit(10)
                .peek(s -> System.out.println("---> " + s))
                .sorted(Comparator.comparing(Seat::price)
                                .thenComparing(Seat::toString));
//                        .mapToDouble(Seat::price).boxed()
//                                .map("%.2f"::formatted);
        stream.forEach(System.out::println);
    }
}
