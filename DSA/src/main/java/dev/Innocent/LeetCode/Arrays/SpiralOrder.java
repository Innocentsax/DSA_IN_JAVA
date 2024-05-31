package dev.Innocent.LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder1(matrix));
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

    // This method passes all the test cases
    public static List<Integer> spiralOrder1(int[][] matrix){
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(boolean[] sub : visited){
            Arrays.fill(sub, false);
        }
        List<Integer> result = new ArrayList<>();

        int m = matrix[0].length;
        int n = matrix.length;
        right(0,0,matrix,result,visited);
        return result;
    }
    private static void right(int i, int j, int[][] matrix,
                              List<Integer> temp, boolean[][] visited) {
        while(j < matrix[0].length && !visited[i][j]){
            temp.add(matrix[i][j]);
            visited[i][j] = true;
            j++;
        }
        if(i + 1 < matrix.length && !visited[i + 1][j - 1]){
            down(i + 1, j - 1, matrix, temp, visited);
        }
    }
    public static void down(int i,int j,int[][] matrix,
                            List<Integer> temp,boolean[][] visited)
    {
        while(i<matrix.length && !visited[i][j])
        {
            temp.add(matrix[i][j]);
            visited[i][j]=true;
            i++;
        }
        if (j - 1 >= 0 && !visited[i - 1][j - 1]) {
            left(i - 1, j - 1, matrix, temp, visited);
        }
    }
    public static void left(int i,int j,int[][] matrix,
                            List<Integer> temp,boolean[][] visited)
    {
        while(j>=0 && !visited[i][j])
        {
            temp.add(matrix[i][j]);
            visited[i][j]=true;
            j--;
        }
        if (i - 1 >= 0 && !visited[i - 1][j + 1]) {
            up(i - 1, j + 1, matrix, temp, visited);
        }
    }
    public static void up(int i,int j,int[][] matrix,
                          List<Integer> temp,boolean[][] visited)
    {
        while (i >= 0 && !visited[i][j]) {
            temp.add(matrix[i][j]);
            visited[i][j] = true;
            i--;
        }
        if (j + 1 < matrix[0].length && !visited[i + 1][j + 1]) {
            right(i + 1, j + 1, matrix, temp, visited);
        }
    }
}