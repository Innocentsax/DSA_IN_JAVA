package dev.InnocentUdo.DSA_With_Kunal.ArrayAndArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class MultiDimensionalArray {
    public static void main(String[] args) {
        /*
        1 2 3
        4 5 6
        7 8 9
         */

        Scanner in = new Scanner(System.in);

        int[][] arr2D = new int[3][3];
        //System.out.println(arr.length);

//        int[][] arr = {
//                {1, 2, 3}, // 0th index
//                {4, 5}, // 1st index
//                {6, 7, 8, 9} // 2nd index
//        };

        // Input
        for (int row = 0; row < arr2D.length; row++) {
            // for each col in every row
            for(int col = 0; col < arr2D[row].length; col++) { // the length of  an array in each row
                arr2D[row] [col] = in.nextInt();
            }
        }

        //Output
        for (int row = 0; row < arr2D.length; row++) {
            // for each col in every row
            for(int col = 0; col < arr2D[row].length; col++) { // the length of  an array in each row
                System.out.print(arr2D[row][col] + " ");
            }
            System.out.println();
        }

        // Using the toString method
        for (int row = 0; row < arr2D.length; row++) {
            System.out.println(Arrays.toString(arr2D[row]));
        }

        // Using for-each loop
        for (int[] a :  arr2D) {
            System.out.println(Arrays.toString(a));
        }
    }
}
