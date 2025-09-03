package dev.Innocent.Section8.ConcurrencyAndMultithreading.Executor;

import dev.Innocent.Section8.ConcurrencyAndMultithreading.MultipleThreads.ThreadColor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

class ColorThreadFactory implements ThreadFactory{
    private String threadName;

    private int colorValue = 1;

    public ColorThreadFactory() {
    }

    public ColorThreadFactory(ThreadColor color) {
        this.threadName = color.name();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        String name = threadName;
        if(name == null){
            name = ThreadColor.values()[colorValue].name();
        }
        if(++colorValue > (ThreadColor.values().length - 1)){
            colorValue = 1;
        }
        thread.setName(name);
        return thread;
    }
}

public class Main {

    public static void main(String[] args) {
        var multExecutor = Executors.newCachedThreadPool();
        try{
            multExecutor.execute(() -> Main.sum(1, 10, 1, "red"));
            multExecutor.execute(() -> Main.sum(10, 100, 10, "blue"));
            multExecutor.execute(() -> Main.sum(2, 20, 2, "green"));

            multExecutor.execute(() -> Main.sum(1, 10, 1, "yellow"));
            multExecutor.execute(() -> Main.sum(10, 100, 10, "cyan"));
            multExecutor.execute(() -> Main.sum(2, 20, 2, "purple"));

            try{
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Next Task will get executed");
        } finally {
            multExecutor.shutdown();
        }
    }

    public static void fixedmain(String[] args) {
        int count = 6;
        var multipleExecutor = Executors.newFixedThreadPool(
                count, new ColorThreadFactory()
        );

        for(int i = 0; i < count; i++){
            multipleExecutor.execute(Main::countDown);
        }
        multipleExecutor.shutdown();
    }

    public static void singlemain(String[] args) {
        var blueExecutor = Executors.newSingleThreadExecutor(
                new ColorThreadFactory(ThreadColor.ANSI_BLUE)
        );
        blueExecutor.execute(Main::countDown);
        blueExecutor.shutdown();

        boolean isDone = false;
        try {
            isDone = blueExecutor.awaitTermination(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(isDone) {
            System.out.println("Blue finished, starting Yellow");
            var yellowExecutor = Executors.newSingleThreadExecutor(
                    new ColorThreadFactory(ThreadColor.ANSI_YELLOW)
            );
            yellowExecutor.execute(Main::countDown);
            yellowExecutor.shutdown();

            try {
                isDone = yellowExecutor.awaitTermination(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if(isDone) {
                System.out.println("Yellow finished, starting Red");
                var redExecutor = Executors.newSingleThreadExecutor(
                        new ColorThreadFactory(ThreadColor.ANSI_RED)
                );
                redExecutor.execute(Main::countDown);
                redExecutor.shutdown();
                try {
                    isDone = redExecutor.awaitTermination(500, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(isDone){
                    System.out.println("All processes completed");
                }
            }
        }
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

    private static void sum(int start, int end, int delta, String colorString){
        var threadColor = ThreadColor.ANSI_RESET;
        try{
            threadColor = ThreadColor.valueOf("ANSI_" + colorString.toUpperCase());
        } catch (IllegalArgumentException e) {
            // User may pass a bad color name, will just ignore this error.
        }

        String color = threadColor.color();
        int sum = 0;
        for(int i = start; i <= end; i += delta){
            sum += i;
        }
        System.out.println(color + Thread.currentThread().getName() + ", " + colorString + " " + sum);
    }
}
