package dev.Innocent.Section8.ConcurrencyAndMultithreading.ParallelProcesses;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int numbersLength = 100_000;
        long[] numbers = new Random().longs(numbersLength, 1, numbersLength).toArray();
    }
}
