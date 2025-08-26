package dev.Innocent.Section8.ConcurrencyAndMultithreading.Executor;

import dev.Innocent.Section8.ConcurrencyAndMultithreading.MultipleThreads.ThreadColor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class ColorThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        return null;
    }
}

public class Main {

    public static void main(String[] args) {
        var blueExecutor = Executors.newSingleThreadExecutor();
        blueExecutor.execute(Main::countDown);
        blueExecutor.shutdown();
    }

    public static void notmain(String[] args) {
        Thread blue = new Thread(
                Main::countDown, ThreadColor.ANSI_BLUE.name());

        Thread yellow = new Thread(
                Main::countDown, ThreadColor.ANSI_YELLOW.name());

        Thread red = new Thread(
                Main::countDown, ThreadColor.ANSI_RED.name());

        blue.start();
        try {
            blue.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        yellow.start();
        try {
            yellow.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        red.start();
        try {
            red.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void countDown(){
        String threadName = Thread.currentThread().getName();
        var threadColor = ThreadColor.ANSI_RESET;
        try{
            threadColor = ThreadColor.valueOf(threadName.toUpperCase());
        } catch (IllegalArgumentException e) {
            // User may pass a bad color name, will just ignore this error.
        }

        String color = threadColor.color();
        for(int i = 20; i >= 0; i--){
            System.out.println(color + " " + threadName.replace("ANSI_", "")
            + " " + i);
        }
    }
}
