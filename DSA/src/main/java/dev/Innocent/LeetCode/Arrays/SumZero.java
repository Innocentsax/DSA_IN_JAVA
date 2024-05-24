package dev.Innocent.LeetCode.Arrays;

import java.util.Arrays;

// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
class SumZero {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(sumZero(n)));
    }
    public static int[] sumZero(int n) {
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[i] = i * 2 - n + 1;
        }
        return newArr;
    }
}