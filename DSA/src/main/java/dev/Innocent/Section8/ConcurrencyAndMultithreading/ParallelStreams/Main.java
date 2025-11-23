package dev.Innocent.Section8.ConcurrencyAndMultithreading.ParallelStreams;


import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int numberLength = 100_000_000;
        long[] number = new Random().longs(numberLength, 1, numberLength).toArray();

        long delta = 0;
        int iteration = 25;

        for (int i = 0; i < iteration; i++) {
            long start = System.nanoTime();
            double averageSerial = Arrays.stream(number).average().orElseThrow();
            long elapsedSerial = System.nanoTime() - start;
//            System.out.printf("Ave = %.2f , elapsed = %d nanos or %.2f ms%n", averageSerial, elapsedSerial, elapsedSerial / 1000000.0);
            start = System.nanoTime();
            double averageParallel = Arrays.stream(number).parallel().average().orElseThrow();
            long elapsedParallel = System.nanoTime() - start;
//            System.out.printf("Ave = %.2f , elapsed = %d nanos or %.2f ms%n", averageParallel, elapsedParallel, elapsedParallel / 1000000.0);

            System.out.printf("Parallel is [%d] nanos or [%.2f] ms faster on average %n",
                    delta / iteration, delta / 1000000.0 / iteration);
        }
    }
}
