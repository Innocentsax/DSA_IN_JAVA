package dev.Innocent.DsaWithDineshVaryani;

import java.util.Arrays;

public class MinNumber {
    public static void main(String[] args) {
        int[] arr = {2,5,1,9,5,6};
        System.out.println(minNumber2(arr));
    }

    private static int minNumber(int[] arr){
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < result){
                result = arr[i];
            }
        }
        return result;
    }

    private static int minNumber1(int[] arr){
        Arrays.sort(arr);
        return arr[0];
    }
}
