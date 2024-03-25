package dev.Innocent.LinearSearch;

import java.util.Arrays;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
            {12, 34, 21, 4},
            {45, 69, 23, 10},
            {49, 2, 4, 67}
        };
        System.out.println(Arrays.toString(search(arr, 23)));
    }

    static int[] search(int[][] arr, int target){
        if(arr.length == 0){
            return new int[]{-1};
        }
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if(arr[row][col] == target)
                    return new int[]{row, col};
            }
        }
        return new int[]{-1};
    }
}
