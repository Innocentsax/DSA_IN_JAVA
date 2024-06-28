package dev.Innocent.DsaWithDineshVaryani;

import java.util.Arrays;

// QA: Given an array of Integer, Write a function to move all 0's to end of it while
// maintaining the relative order of the Non-Zero element.
public class ZeroesToEnd {
    public static void main(String[] args) {
        int[] arr = {8, 1, 0, 2, 1, 0, 3};
        System.out.println(Arrays.toString(zerosAtEnd(arr, 7)));
    }

    public static int[] zeroesToEnd(int[] arr){
        int n = arr.length;
        int checkIfNumberIsZero = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] != 0 && arr[checkIfNumberIsZero] == 0){
                int temp = arr[i];
                arr[i] = arr[checkIfNumberIsZero];
                arr[checkIfNumberIsZero] = temp;
            }
            if(arr[checkIfNumberIsZero] != 0){
                checkIfNumberIsZero++;
            }
        }
        return arr;
    }

    public static int[] zerosAtEnd(int[] arr, int n){
        int j = 0; // Focus on numbers that are Zeros
        for(int i = 0; i < n; i++){ // Focus on numbers that are not Zeros
            if (arr[i] != 0 && arr[j] == 0) { // If this is all true
                // Perform a swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j] != 0){
                j++;
            }
        }
        return arr;
    }
}
