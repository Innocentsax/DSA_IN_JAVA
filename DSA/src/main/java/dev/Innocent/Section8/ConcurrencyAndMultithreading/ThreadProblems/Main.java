package dev.Innocent.Section8.ConcurrencyAndMultithreading.ThreadProblems;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File resourceA = new File("inputData.csv");
        File resourceB = new File("outputData.json");

        Thread thread = new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "attempting to lock resourcesA (csv)");
            synchronized (resourceA){
                System.out.println(threadName + " has lock on resourceA (csv)");
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(threadName + " has released lock on resourceA (csv)");
        }, "THREAD-A");
    }
}
