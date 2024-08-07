package dev.Innocent.LeetCode.Arrays;


import java.util.Arrays;

// https://leetcode.com/problems/reshape-the-matrix/description/
class MatrixReshape {
    public static void main(String[] args) {
        int[][] mat = {{1,2},{3,4}};
        int r = 1, c = 4;
        System.out.println(Arrays.deepToString(matrixReshape(mat, r, c)));
    }
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        // Count the number of pieces
        int m = mat.length; // Number of row in the original Matrix
        int n = mat[0].length; // Number of col in the original matrix
        int totalElement = m * n;

        // Check if reshaping is possible
        if(totalElement != r*c){
            return mat;
        }
         // Create the new shape
        int[][] newShape = new int[r][c];
        int row = 0, col = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newShape[row][col] = mat[i][j];
                col++;
                if(col == c){
                    col = 0;
                    row++;
                }
            }
        }
        return newShape;
    }
}