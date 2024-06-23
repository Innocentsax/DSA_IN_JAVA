package dev.Innocent.DsaWithDineshVaryani;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayIntro {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(evenInteger(arr)));
        System.out.println(removeEven(arr));
    }

    // Q1. Given an array of Integers, return an array with integers removed
    public static int[] evenInteger(int[] arr){
        int oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 != 0){
                oddCount++;
            }
        }
        int[] result = new int[oddCount];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 != 0){
                result[index] = arr[i];
                index++;
            }
        }
        return result;
    }

    public static List<Integer> removeEven(int[] arr){
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 0){
                ans.add(i);
            }
        }
        return ans;
    }
}
