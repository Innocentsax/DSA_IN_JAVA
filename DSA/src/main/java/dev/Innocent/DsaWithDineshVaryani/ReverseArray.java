package dev.Innocent.DsaWithDineshVaryani;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 2, 3};
        reverseArray(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverseArray(int[] numbers, int start, int end){
        while(start < end){
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
    }
}
