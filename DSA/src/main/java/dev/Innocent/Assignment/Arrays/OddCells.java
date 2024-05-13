package dev.Innocent.Assignment.Arrays;
// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
class OddCells {
    public static void main(String[] args) {

    }
    public int oddCells(int m, int n, int[][] indices) {
        // Initialize matrix with all Zeros
        int[][] matrix = new int[m][n];

        // Perform increment operation on the matrix
        for(int[] index : indices){
            int row = index[0];
            int col = index[1];
            
            //Increment all cells in the role
            for (int j = 0; j < n; j++) {
                matrix[row][j]++;
            }

            // Increment all cells in the column
            for (int i = 0; i < m; i++) {
                matrix[i][col]++;
            }
        }
        // Count the number of odd-value cells
        int oddCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] % 2 != 0){
                    oddCount++;
                }
            }
        }
        return oddCount;
    }
}