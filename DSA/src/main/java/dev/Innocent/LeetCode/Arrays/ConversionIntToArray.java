package dev.Innocent.LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/add-to-array-form-of-integer/
class ConversionIntToArray {
    public static void main(String[] args) {
        int[] num = {2,7,4};
        int k = 181;
        System.out.println(addToArrayForm1(num, k));
    }

    // My thought process
    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> newArray = new ArrayList<>();

        // Concatenate digits into a single string
        StringBuilder conNum = new StringBuilder();
        for(int i : num){
            conNum.append(i);
        }
        // Parse the string to an Integer
        int result = Integer.parseInt(conNum.toString());
        int sum = result + k;

        // Extract digits one by one using modulo operation
        while(sum > 0){
            int digit = sum % 10;
            newArray.add(digit);
            sum /=10;
        }
        Collections.reverse(newArray);
        return newArray;
    }

    // From external source
    public static List<Integer> addToArrayForm1(int[] num, int k) {
        List<Integer> newArray = new ArrayList<>();
        int carry = 0;

        int i = num.length - 1;
        while (i >= 0 || k > 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num[i];
            }
            if (k > 0) {
                sum += k % 10;
                k /= 10;
            }
            newArray.add(sum % 10);
            carry = sum / 10;
            i--;
        }

        Collections.reverse(newArray);
        return newArray;
    }
}