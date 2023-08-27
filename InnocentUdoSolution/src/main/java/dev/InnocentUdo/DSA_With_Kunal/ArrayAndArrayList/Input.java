package dev.InnocentUdo.DSA_With_Kunal.ArrayAndArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Array of primitives
        int[] arr = new int[5];
        arr[0] = 23;
        arr[1] = 45;
        arr[2] = 33;
        arr[3] = 43;
        arr[4] = 3;
        // [23, 45, 33, 43, 3]
        System.out.println(arr[3]);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        // input using for loop
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // input using for each loop
        for(int num : arr){ // for every element in array, print the element
            System.out.print(num + " "); // here num represents element of the array
        }

        // Using the Arrays.toString method
        System.out.println(Arrays.toString(arr));

        // Array of Object
        String[] str = new String[4];
        for (int i = 0; i < str.length; i++) {
            str[i] = in.next();

        }
        System.out.println(Arrays.toString(str));

        // Modify
        str[2] = "Innocent";
        str[3] = "Udo";
        System.out.println(Arrays.toString(str));
    }
}
