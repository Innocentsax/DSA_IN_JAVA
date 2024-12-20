package dev.Innocent.Section7.Generics;

import java.util.ArrayList;
import java.util.List;

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
    }
}
