package dev.Innocent.refresh;

import java.util.HashSet;

public class FindDuplicate {

    public static void main(String[] args) {
        int[] numbers = {4, 2, 7, 4, 8, 2, 9, 7};

        findDuplicate(numbers);
    }

    private static void findDuplicate(int[] arr){
        HashSet<Integer> orig = new HashSet<>();
        HashSet<Integer> dup = new HashSet<>();

        for(int num : arr){
            if(!orig.add(num)){
                dup.add(num);
            }
        }

        System.out.println(dup);
    }
}
