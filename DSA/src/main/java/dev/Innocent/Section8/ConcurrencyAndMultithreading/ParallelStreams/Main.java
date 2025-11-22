package dev.Innocent.Section8.ConcurrencyAndMultithreading.ParallelStreams;


import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int numberLength = 100_000;
        long[] number = new Random().longs(numberLength, 1, numberLength).toArray();
        long start = System.nanoTime();
        double averageSerial = Arrays.stream(number).average().orElseThrow();
        long elapsedSerial = System.nanoTime() - start;
        System.out.printf("Ave = %.2f , elapsed = %d nanos or %.2f ms%n", averageSerial, elapsedSerial, elapsedSerial/1000000.0);
    }
}
