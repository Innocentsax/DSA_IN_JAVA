package dev.Innocent.Section8.ConcurrencyAndMultithreading.ParallelProcesses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

class RecursiveSumTask extends RecursiveTask<Long>{

    private final long[] number;
    private final int start;
    private final int end;
    private final int division;

    public RecursiveSumTask(long[] number, int start, int end, int division) {
        this.number = number;
        this.start = start;
        this.end = end;
        this.division = division;
    }

    @Override
    protected Long compute() {
        if((end - start) <= (number.length / division)){
            System.out.println(start + " : " + end);
            long sum = 0;
            for(int i = start; i < end; i++){
                sum += number[i];
            }
            return sum;
        }else {
            
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {

        int numbersLength = 100_000;
        long[] numbers = new Random().longs(numbersLength, 1, numbersLength).toArray();

        long sum = Arrays.stream(numbers).sum();
        System.out.println("sum = " + sum);

        ForkJoinPool threadPool = ForkJoinPool.commonPool();
        List<Callable<Long>> tasks = new ArrayList<>();

        int taskNo = 10;
        int splitCount = numbersLength / taskNo;
        for (int i = 0; i < taskNo; i++) {
            int start = i * splitCount;
            int end = start + splitCount;
            tasks.add(() -> {
                long taskSum = 0;
                for (int j = start; j < end; j++) {
                    taskSum += numbers[j];
                }
                return taskSum;
            });
        }

        List<Future<Long>> futures = threadPool.invokeAll(tasks);

        System.out.println("CPUs: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Parallelism = " + threadPool.getParallelism());
        System.out.println("Pool size = " + threadPool.getPoolSize());
        System.out.println("Steal count = " + threadPool.getStealCount());

        long taskSum = 0;
        for(Future<Long> future : futures){
            taskSum += future.get();
        }

        System.out.println("Thread Pool sum " + taskSum);
        threadPool.shutdown();
        System.out.println(threadPool.getClass().getName());
    }
}
