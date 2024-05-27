package dev.Innocent.LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/lucky-numbers-in-a-matrix/
class LuckyNumber {
    public static void main(String[] args) {
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        System.out.println(luckyNumbers(matrix));
    }
    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckyNum = new ArrayList<>();

        for (int[] ints : matrix) {
            int minNum = Integer.MAX_VALUE;
            int col = 0;

            for (int j = 0; j < ints.length; j++) {
                if (minNum > ints[j]) {
                    minNum = ints[j]; // This gives the minimum element in that array
                    col = j;
                }
            }

            boolean isTrue = true;
            for (int[] value : matrix) {
                if (ints[col] < value[col]) {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue) {
                luckyNum.add(ints[col]);
            }
        }
        return luckyNum;
    }
}