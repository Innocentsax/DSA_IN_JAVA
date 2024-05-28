package dev.Innocent.LeetCode.Arrays;

import java.util.Arrays;

// https://leetcode.com/problems/plus-one/description/
class PlusOne {
    public static void main(String[] args) {
        int[] digits = {1,2,3};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
    public static int[] plusOne(int[] digits) {
        // Start from the last element
        for (int i = digits.length - 1; i >= 0; i--) {
            // If the digit is less than 9, add one and return the result
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            // If the digit is 9, set it to 0;
            digits[i] = 0;
        }
        // If all the digits are 9, we need an extra digit at the beginning
        int[] newDigit = new int[digits.length + 1];
        newDigit[0] = 1;
        return newDigit;
    }
}