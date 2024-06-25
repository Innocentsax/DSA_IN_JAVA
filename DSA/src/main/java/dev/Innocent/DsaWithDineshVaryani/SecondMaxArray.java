package dev.Innocent.DsaWithDineshVaryani;


import java.util.Arrays;

// QA: Given an array of Integers, return the second maximum value. The Second maximum value exist
public class SecondMaxArray {
    public static void main(String[] args) throws Exception {
        int[] arr = {12, 34, 2, 34, 33, 1};
        System.out.println(secondMax1(arr));
    }

    // This method those not work for array that has duplicate Max numbers
    private static int secondMax(int[] arr) throws Exception {
        if(arr == null || arr.length == 0){
            throw new Exception("Invalid Input");
        }
        Arrays.sort(arr);
        return arr[arr.length - 2];
    }

    private static int secondMax1(int[] arr) throws Exception {
        if(arr == null || arr.length == 0){
            throw new Exception("Invalid Input");
        }
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    private static int secondMax2(int[] arr) throws Exception {
        if(arr == null || arr.length == 0){
            throw new Exception("Invalid Input");
        }
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > max) {
                secondMax = max;
                max = j;
            } else if (j > secondMax && j != max) {
                secondMax = j;
            }
        }
        return secondMax;
    }
}
