package dev.Innocent.SortingArrays;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 8};
        cylicSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void cylicSort(int[] arr){
        int i = 0; // Pointer
        while(i < arr.length){
            int correct = arr[i] - 1;
            if(correct >= 0 && correct < arr.length && arr[i] != arr[correct]){
                swap(arr, i, correct);
            }else {
                i++;
            }
        }
    }

    static void cylicSort3(int[] arr) {
        int i = 0; // Pointer
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (correct >= 0 && correct < arr.length && arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    // Or you can use this
    static void cylicSort2(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }else{
                i++;
            }
        }
    }
}
