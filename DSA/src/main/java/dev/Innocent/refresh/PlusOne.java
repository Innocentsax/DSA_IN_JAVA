package dev.Innocent.refresh;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    // My throught
    public static int[] plusOne1(int[] digits){
//        int[] res = Arrays.stream(digits).sorted().toArray();
        int last = digits.length - 1;
        for(int i = 0; i < digits.length; i++){
            if(digits[i] == digits[last]){
                digits[i]++;
            }
        }
        return digits;
    }

    public static int[] plusOne(int[] digits){
        for(int i = digits.length - 1; i >= 0; i++){
            if(digits[i] == 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
