package dev.Innocent.LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/lucky-numbers-in-a-matrix/
class LuckyNumber {
    public static void main(String[] args) {

    }
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckyNum = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int minNum = Integer.MAX_VALUE;
            int col = 0;

            for (int j = 0; j < matrix[i].length; j++) {
                if(minNum > matrix[i][j]){
                    minNum = matrix[i][j]; // This gives the minimum element in that array
                    col = j;
                }
            }

            boolean isTrue = true;
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][col] < matrix[j][col]){
                    isTrue = false;
                    break;
                }
            }
            if(isTrue){
                luckyNum.add(matrix[i][col]);
            }
        }
        return luckyNum;
    }
}