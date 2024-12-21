package dev.Innocent.Section7.Generics;

import java.util.ArrayList;
import java.util.List;
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

    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2){
        T result = function.apply(value1, value2);
        System.out.println("Result of Operation: " + result);
        return result;
    }
}
