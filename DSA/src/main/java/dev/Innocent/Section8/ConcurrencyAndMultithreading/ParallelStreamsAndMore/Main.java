package dev.Innocent.Section8.ConcurrencyAndMultithreading.ParallelStreamsAndMore;

import java.util.Random;

record Person(String firstName, String lastName, int age){
    private final static String[] firsts = {"Able", "Bob", "Charlie", "Donna", "Eve", "Fred"};
    private final static String[] lasts = {"Norton", "OHara", "Petersen", "Quincy", "Richardson", "Smith"};

    private final static Random random = new Random();

    public Person(){
        this(firsts[random.nextInt(firsts.length)], lasts[random.nextInt()], random.nextInt(18, 100));
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
