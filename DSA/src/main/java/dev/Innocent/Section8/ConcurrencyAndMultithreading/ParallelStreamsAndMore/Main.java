package dev.Innocent.Section8.ConcurrencyAndMultithreading.ParallelStreamsAndMore;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.Stream;

record Person(String firstName, String lastName, int age){
    private final static String[] firsts = {"Able", "Bob", "Charlie", "Donna", "Eve", "Fred"};
    private final static String[] lasts = {"Norton", "OHara", "Petersen", "Quincy", "Richardson", "Smith"};

    private final static Random random = new Random();

    public Person(){
        this(firsts[random.nextInt(firsts.length)], lasts[random.nextInt(lasts.length)], random.nextInt(18, 100));
    }

    @Override
    public String toString() {
        return "%s, %s (%d)".formatted(lastName, firstName, age);
    }
}

public class Main {
    public static void main(String[] args) {

        Stream.generate(Person::new)
                .limit(10)
                .parallel()
                .sorted(Comparator.comparing(Person::lastName))
                .forEachOrdered(System.out::println);
    }
}
