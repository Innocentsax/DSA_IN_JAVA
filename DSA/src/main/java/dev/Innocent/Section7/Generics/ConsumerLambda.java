package dev.Innocent.Section7.Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

public class ConsumerLambda {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta"
        ));

        for(String s : list){
            System.out.println(s);
        }

        System.out.println("-----------");
        list.forEach((s) -> System.out.println(s));

        System.out.println("-----------");
        String prefix  = "nato";
        list.forEach((var s) -> {
            char first = s.charAt(0);
            System.out.println(prefix + " " + s + " means " + first);
        });

        int result = calculator((var a, var b) -> (a + b), 5, 2);

        System.out.println("-------------");

        var coords = Arrays.asList(
                new double[]{47.2160, -95.2348},
                new double[]{29.1566, -89.2495},
                new double[]{35.1556, -90.0659}
        );
        coords.forEach(s -> System.out.println(Arrays.toString(s)));

        
    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2){
        T result = function.apply(value1, value2);
        System.out.println("Result of Operation: " + result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer){
        consumer.accept(t1, t2);
    }
}
