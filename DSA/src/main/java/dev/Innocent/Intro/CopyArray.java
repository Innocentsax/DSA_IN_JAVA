package dev.Innocent.Intro;

import java.util.Arrays;

/* Declare a single array variable of type double and initialize the array
- Assign a value to array
- Copy one array to another array
- Pass array to a method
 */
public class CopyArray {
    public static void main(String[] args) {
        double[] mainArray = {1, 2, 3, 41, 5};
        double[] newCopiedArray = mainArray.clone();
        System.out.println(Arrays.toString(newCopiedArray));
        copiedArray(mainArray);
    }
    
    static void copiedArray(double[] arr){
        double newArray = 0;
        for(double num : arr){
            System.out.println(num + " ");
        }
        System.out.println(newArray);
    }
}
