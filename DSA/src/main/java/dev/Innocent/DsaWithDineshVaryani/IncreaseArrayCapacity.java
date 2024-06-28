package dev.Innocent.DsaWithDineshVaryani;

import java.util.Arrays;

public class IncreaseArrayCapacity {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(resize(arr, 8)));
    }

    public static int[] resize(int[] arr, int capacity){
        int[] temp = new int[capacity];
        for(int i = 0; i < arr.length; i++){
            temp[i] = arr[i];
        }
        arr = temp;
        return arr;
    }
}
