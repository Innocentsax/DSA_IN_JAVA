package dev.Innocent.DsaWithDineshVaryani;

import java.util.Arrays;

public class ArrayIntro {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(evenInteger(arr)));
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
}
