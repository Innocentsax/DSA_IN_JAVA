package dev.Innocent.Section8.ConcurrencyAndMultithreading.ParallelStreams;


import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int numberLength = 100_000;
        long[] number = new Random().longs(numberLength, 1, numberLength).toArray();
        long start = System.nanoTime();
        double averageSerial = Arrays.stream(number).average().orElseThrow();
    }
}
