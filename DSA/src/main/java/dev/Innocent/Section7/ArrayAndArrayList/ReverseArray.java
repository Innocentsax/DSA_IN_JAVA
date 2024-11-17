package dev.Innocent.Section7.ArrayAndArrayList;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] tt = {1, 2, 3, 4, 5, 6};
        reverse(tt);
        System.out.println(Arrays.toString(tt));
    }
    // using normal Swap method
    private static void reverse1(int[] array){
        int length = array.length - 1;
        for (int i = 0; i < array.length/2; i++) {
            int temp = array[i];
            array[i] = array[length - i];
            array[length - i] = temp;
        }
    }

    // using binary Search
    private static void reverse(int[] array){
        int left = 0;
        int right = array.length - 1;

        while (left < right){
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }
    }
}