package dev.Innocent.Section8.ConcurrencyAndMultithreading.SchedulingTasks;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

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
    }
}
