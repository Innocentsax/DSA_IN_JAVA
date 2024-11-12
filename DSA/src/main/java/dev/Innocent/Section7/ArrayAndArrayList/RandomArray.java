package dev.Innocent.Section7.ArrayAndArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class RandomArray {
    public static void main(String[] args) {
        int[] firstArray = getRandomArray(10);
        System.out.println(Arrays.toString(firstArray));

        // Using the sort function
        Arrays.sort(firstArray);
        System.out.println(Arrays.toString(firstArray));

        // Using the fill function
        int[] secondArray = new int[10];
        System.out.println(Arrays.toString(secondArray));
        Arrays.fill(secondArray, 5);
        System.out.println(Arrays.toString(secondArray));

        //Using the CopyOf function
        int[] thirdArray = getRandomArray(10);
        System.out.println(Arrays.toString(thirdArray));

        int[] fourthArray = Arrays.copyOf(thirdArray, thirdArray.length);
        System.out.println(Arrays.toString(fourthArray));

        // Using the Binary Search function
        String[] sArray = {"Able", "Jane", "Mark", "Ralph", "David"};
        Arrays.sort(sArray);
        System.out.println(Arrays.toString(sArray));
        if(Arrays.binarySearch(sArray, "Mark") >= 0){
            System.out.println("Found Mark in the lists");
        }
    }

    private static int[] getRandomArray(int len){
        Random random = new Random();
        int[] newInt = new int[len];
        for (int i = 0; i < len; i++) {
            newInt[i] = random.nextInt(100);
        }
        return newInt;
    }
}
