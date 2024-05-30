package dev.Innocent.LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }

    // I tried but i didn't pass all the test cases 👀
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return result;
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while(top <= bottom && left <= right){
            // Traverse from left to right across the top row
            for (int i = left; i <= right ; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Move the top boundary down

            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[right][i]);
            }
            right--; // Move the right boundary left

            // Traverse from right to left across the bottom row(If still within the boundaries)
            if(top <= bottom){
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Move the bottom boundary up
            }

            // Traverse from bottom to top along the left column (if still within boundaries)
            if(left <= right){
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Move the left boundary right
            }
        }
        return result;
    }
}