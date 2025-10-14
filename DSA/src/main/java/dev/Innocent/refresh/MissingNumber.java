package dev.Innocent.refresh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingNumber {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Array", "David", "Man");
        java6version(list);
        java8version(list);

        int[] nm = {1, 2, 4, 5, 6};
        int n = 6;
        int result = findMissingNumber(nm, n);
        System.out.println(result);
    }

    //1.  Create a class in Java 6 version and Java 8 version. Filter out names that start with "A"
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

    //2. Find the missing number in an array of 1…n.
    public static int findMissingNumber(int[] arr, int n){
        int expectedNum = n * (n + 1) / 2;
        int actual = 0;

        for(int num : arr){
            actual += num;
        }
        return expectedNum - actual;
    }
}
