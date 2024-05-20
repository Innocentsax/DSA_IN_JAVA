package dev.Innocent.LeetCode.Arrays;

// https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
class FindRotation {
    public static void main(String[] args) {
       int[][] mat = {{0,1},{1,0}};
       int[][] target = {{1,0},{0,1}};
        System.out.println(findRotation1(mat, target));
    }

    // Don't pass all test
    public static boolean findRotation(int[][] mat, int[][] target) {
        if(areMatricsEqual(mat, target)){
            return true;
        }
        // Rotate up to 3 times (90, 180, 270 degree)
        for (int i = 0; i < 3; i++) {
            mat = rotate90DegreeClockwise(mat);
            if(areMatricsEqual(mat, target)){
                return true;
            }
        }
        return false;
    }

    // This method is to rotate the matrix in 90 degree
    private static int[][] rotate90DegreeClockwise(int[][] mat) {
        int n = mat.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - j] = mat[i][j];
            }
        }
        return rotated;
    }

    // This method is to check if the two matrices are equal
    private static boolean areMatricsEqual(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == target[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean findRotation1(int[][] mat, int[][] target){
        int n = mat.length;
        int c90 = 0, c180 = 0, c270 = 0, c0 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(target[i][j] == mat[n-j-1][i]){
                    c90++;
                }
                if(target[i][j] == mat[n-i-1][n-j-1]){
                    c180++;
                }
                if(target[i][j] == mat[j][n-i-1]){
                    c270++;
                }
                if(target[i][j] == mat[i][j]){
                    c0++;
                }
            }
        }
        return c90 == n * n || c180 == n * n || c270 == n * n || c0 == n * n;
    }
}