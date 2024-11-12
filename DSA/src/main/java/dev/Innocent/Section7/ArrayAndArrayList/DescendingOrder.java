package dev.Innocent.Section7.ArrayAndArrayList;

import java.util.Arrays;
import java.util.Random;

public class DescendingOrder {
    public static void main(String[] args) {
        int[] firstArray = getRandomArray(10);
        Arrays.sort(firstArray);
        System.out.println(Arrays.toString(firstArray));

        reverse(firstArray);
        System.out.println(Arrays.toString(firstArray));
    }

    public static int[] getRandomArray(int len){
        Random newRan = new Random();
        int[] newArray = new int[len];
        for (int i = 0; i < len; i++) {
            newArray[i] = newRan.nextInt(1000);
        }
        return newArray;
    }

    public static void reverse(int[] array){
        int len = array.length;
        for (int i = 0; i < len/2; i++) {
            int temp = array[i];
            array[i] = array[len - i - 1];
            array[len - i - 1] = temp;
        }
    }
}
