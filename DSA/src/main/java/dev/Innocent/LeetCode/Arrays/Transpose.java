package dev.Innocent.LeetCode.Arrays;

import java.util.Arrays;

class Transpose {
    public static void main(String[] args) {
       int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(transpose(matrix)));
    }
    public static int[][] transpose(int[][] matrix) {
        // Get the size of the original matrix
        int row = matrix.length;
        int col = matrix[0].length;

        // Create a new matrix for the Transpose with Swapped dimension
        int[][] transposeMatrix = new int[col][row];

        // Loop through each number in the original matrix
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // Put the number in the right place in the transpose matrix
                // We swap the row and cols indices
                transposeMatrix[j][i] = matrix[i][j];
            }
        }
        return transposeMatrix;
    }
}