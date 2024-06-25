package dev.Innocent.DsaWithDineshVaryani;

import java.util.Arrays;

// QA: Given an array of Integer, Write a function to move all 0's to end of it while
// maintaining the relative order of the Non-Zero element.
public class ZeroesToEnd {
    public static void main(String[] args) {
        int[] arr = {8, 1, 0, 2, 1, 0, 3};
        System.out.println(Arrays.toString(zeroesToEnd(arr)));
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
}
