package dev.Innocent.Section8.ConcurrencyAndMultithreading.ParallelProcesses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        int numbersLength = 100_000;
        long[] numbers = new Random().longs(numbersLength, 1, numbersLength).toArray();

        long sum = Arrays.stream(numbers).sum();
        System.out.println("sum = " + sum);

        ExecutorService threadPool = Executors.newWorkStealingPool(4);
        List<Callable<Long>> tasks = new ArrayList<>();
    }
}
