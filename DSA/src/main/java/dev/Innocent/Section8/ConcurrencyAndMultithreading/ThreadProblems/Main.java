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
                System.out.println(threadName + " NEXT attempting to lock resourceB (json), " +
                        "still has lock on resource A (csv)");
                synchronized (resourceB){
                    System.out.println(threadName + " has lock on resourceB (json)");
                }
                System.out.println(threadName + " has released lock on resourceB (json)");
            }
            System.out.println(threadName + " has released lock on resourceA (csv)");
        }, "THREAD-A");

        Thread threadB = new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "attempting to lock resourcesB (json)");
            synchronized (resourceB){
                System.out.println(threadName + " has lock on resourceB (json)");
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadName + " NEXT attempting to lock resourceA (json), " +
                        "still has lock on resource B (csv)");
                synchronized (resourceB){
                    System.out.println(threadName + " has lock on resourceA (json)");
                }
                System.out.println(threadName + " has released lock on resourceA (json)");
            }
            System.out.println(threadName + " has released lock on resourceB (json)");
        }, "THREAD-B");

        thread.start();
        threadB.start();

        try {
            thread.join();
            threadB.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
