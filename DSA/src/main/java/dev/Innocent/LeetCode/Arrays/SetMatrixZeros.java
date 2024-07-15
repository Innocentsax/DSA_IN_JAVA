package dev.Innocent.LeetCode.Arrays;

import java.util.Arrays;

public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };

        setZero(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void setZero(int[][] matrix){
        boolean firstRow = false;
        boolean firstColumn = false;

        // Set markers in first row and first column
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    if(i == 0) firstRow = true;
                    if(j == 0) firstColumn = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // Replace the inner matrix
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        // Last remaining check
//        if(firstRow){
//            Arrays.fill(matrix[0], 0);
//        }
//
//        if(firstColumn){
//            Arrays.fill(matrix[0], 0);
//        }

        if(firstRow){
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if(firstColumn){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
