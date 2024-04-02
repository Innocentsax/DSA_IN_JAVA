package dev.Innocent.Intro;

import java.util.Arrays;

/* Declare a single array variable of type double and initialize the array
- Assign a value to array
- Copy one array to another array
- Pass array to a method
 */
public class Assign {
    public static void main(String[] args) {
        double[] number = {1.5, 2.3, 3.4, 4.5, 5.5};
        double[] newArray = number.clone(); // You can also use the function to directly copy the array.
        System.out.printf(Arrays.toString(copied(number)));
    }
    static double[] copied(double[] arr){
        double[] newArr = new double[arr.length]; // Create a new array to store the copied values
        // Copy each element from the original array to the new array
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        return newArr; // Return the copied array
    }

    static double[] copied2(double[] arr){
        double[] newArr = new double[arr.length]; // Create a new array to store the copied values
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i]; // Copy each element from the original array to the new array
        }
        return newArr; // Return the copied array
    }
}
