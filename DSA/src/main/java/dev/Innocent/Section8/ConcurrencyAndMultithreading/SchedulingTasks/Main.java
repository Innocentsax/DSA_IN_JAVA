package dev.Innocent.Section8.ConcurrencyAndMultithreading.SchedulingTasks;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        var dtf = DateTimeFormatter.ofLocalizedDateTime(
                FormatStyle.MEDIUM, FormatStyle.LONG
        );

        Callable<ZonedDateTime> waitThenDoIt = () -> {
            ZonedDateTime zdt = null;
            try{
                TimeUnit.SECONDS.sleep(2);
                zdt = ZonedDateTime.now();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            return zdt;
        };

        var threadPool = Executors.newFixedThreadPool(2);
        List<Callable<ZonedDateTime>> list = Collections.nCopies(4, waitThenDoIt);
        try{
            System.out.println("--->" + ZonedDateTime.now().format(dtf));
            List<Future<ZonedDateTime>> futureList = threadPool.invokeAll(list);
            for(Future<ZonedDateTime> result : futureList){
                try {
                    System.out.println(result.get(1, TimeUnit.SECONDS).format(dtf));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            threadPool.shutdown();
        }

        Runnable dateTask = () -> {
            try{
                TimeUnit.SECONDS.sleep(3);
                System.out.println("a " + ZonedDateTime.now().format(dtf));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        System.out.println("----> " + ZonedDateTime.now().format(dtf));
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);
        var scheduledTask = executor.scheduleAtFixedRate(dateTask, 2, 2, TimeUnit.SECONDS);
        var scheduledTask2 = executor.scheduleAtFixedRate(
                () -> System.out.println("b" + ZonedDateTime.now().format(dtf)),
                2, 2, TimeUnit.SECONDS);
        long time = System.currentTimeMillis();
        while(!scheduledTask.isDone()){
            try {
                TimeUnit.SECONDS.sleep(2);
                if ((System.currentTimeMillis() - time) / 1000 > 10) {
                    scheduledTask.cancel(true);
                }
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }

        executor.shutdown();
    }
}
