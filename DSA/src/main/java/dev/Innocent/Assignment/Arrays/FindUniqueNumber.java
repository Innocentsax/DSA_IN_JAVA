package dev.Innocent.Assignment.Arrays;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FindUniqueNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3,3,4,4,6};
        System.out.println(uniqueNumber1(arr));
    }
    private static int uniqueNumber(int[] arr){
        int unique = 0;
        for(int n : arr){
            unique ^= n;
        }
        return unique;
    }

    // Practical bullshit
    private static Set<Integer> uniqueNumber1(int[] arr){
        int max = arr.length - 1;
        Set<Integer> num = new HashSet<>();
        for (int i = 0; i < max; i++) {
            num.add(i);
            System.out.println(num);
        }
        for (int j = 0; j < arr.length; j++) {
            num.remove(arr[j]);
            if(num.isEmpty()){
                return Collections.singleton(-1);
            }
        }
        return num;
    }
}
