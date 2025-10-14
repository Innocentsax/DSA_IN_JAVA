package dev.Innocent.refresh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingNumber {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Array", "David", "Man");
        java6version(list);
        java8version(list);
    }

    //1.  Create a class in Java 6 version and Java 8 version. Filter out names that start with "A"
    //2. Find the missing number in an array of 1…n.

    public static void java6version(List<String> list){
        List<String> filtered = new ArrayList<>();
        for(String name : list){
            if(!name.startsWith("A")){
                filtered.add(name);
            }
        }
        System.out.println(filtered);
    }

    public static void java8version(List<String> list){
        List<String> filtered = list.stream().filter(name -> !name.startsWith("A")).toList();
        System.out.println(filtered);
    }
}
