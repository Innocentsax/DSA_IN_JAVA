package dev.Innocent.BubbleSort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bubbleSort(int[] arr){
        // run the steps n - 1 times
        for (int first = 0; first < arr.length; first++) {
            // for each step, max item will come at the last respective index
            for (int second = 1; second < arr.length - first; second++) {
                // Swap if the item is similar than the previous
                if (arr[second] < arr[second - 1]) {
                    // Swap
                    int temp = arr[second];
                    arr[second] = arr[second - 1];
                    arr[second - 1] = temp;
                }
            }
        }
    }

    static void bubbleSort2(int[] arr){
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if(arr[j] < arr[j - 1]){
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            // If you did not swap for a particular value of i, it means the array is sorted, hence stop the program
            if(!swapped){
                break;
            }

        }
    }
}
