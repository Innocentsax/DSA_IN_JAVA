package dev.Innocent.Section8.ConcurrencyAndMultithreading.Thread;

public class Main {
    public static void main(String[] args) {
        var currentThread = Thread.currentThread();
        System.out.println(currentThread.getClass().getName());
    }
}
