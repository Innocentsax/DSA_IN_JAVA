package dev.Innocent.DsaWithDineshVaryani;


import java.util.Arrays;

// QA: Given an array of Integers, return the second maximum value. The Second maximum value exist
public class SecondMaxArray {
    public static void main(String[] args) throws Exception {
        int[] arr = {12, 34, 2, 34, 33, 1};
        System.out.println(secondMax(arr));
    }

    // This method those not work for array that has duplicate Max numbers
    private static int secondMax(int[] arr) throws Exception {
        if(arr == null || arr.length == 0){
            throw new Exception("Invalid Input");
        }
        Arrays.sort(arr);
        return arr[arr.length - 2];
    }
}
