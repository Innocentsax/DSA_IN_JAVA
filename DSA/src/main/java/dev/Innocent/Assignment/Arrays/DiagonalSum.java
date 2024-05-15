package dev.Innocent.Assignment.Arrays;

// https://leetcode.com/problems/matrix-diagonal-sum/description/
class DiagonalSum {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(diagonalSum(mat));
    }
    public static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int primarySum = 0;
        int secondarySum = 0;

        // Sum of primary diagonal
        for (int i = 0; i < n; i++) {
            primarySum += mat[i][i];
        }

        // Sum of secondary diagonal (excluding elements of primary diagonal)
        for (int j = 0; j < n; j++) {
            // n-1-j gives the index of the element on the secondary diagonal
            secondarySum += mat[j][n - 1 - j];
        }

        // If the matrix has odd dimensions, subtract the middle element counted twice
        if(n % 2 != 0){
            int mid = n / 2;
            primarySum -= mat[mid][mid];
        }
        return primarySum + secondarySum;
    }
}