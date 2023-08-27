package dev.InnocentUdo.DSA_With_Kunal.ArrayAndArrayList;

import java.util.Arrays;

public class ColNoFixed {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4}, {5, 6}, {7, 8, 9}
        };

        System.out.println("===> Using for loop <===");
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println("===>Using Foreach loop <===");
        for (int[] a: arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}
