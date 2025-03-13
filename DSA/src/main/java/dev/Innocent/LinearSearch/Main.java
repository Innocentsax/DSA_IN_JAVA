package dev.Innocent.LinearSearch;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static long[] solution(int rows, int cols, int[][] black) {
        long[] result = new long[5]; // To store counts of submatrices with 0 to 4 black cells
        Map<String, Integer> blackCells = new HashMap<>();
        
        // Mark black cell positions
        for (int[] cell : black) {
            blackCells.put(cell[0] + "," + cell[1], 1);
        }
        
        // Iterate through all possible top-left corners of 2x2 submatrices
        for (int r = 0; r < rows - 1; r++) {
            for (int c = 0; c < cols - 1; c++) {
                int blackCount = 0;
                
                // Check all four cells in the 2x2 submatrix
                if (blackCells.containsKey(r + "," + c)) blackCount++;
                if (blackCells.containsKey(r + "," + (c + 1))) blackCount++;
                if (blackCells.containsKey((r + 1) + "," + c)) blackCount++;
                if (blackCells.containsKey((r + 1) + "," + (c + 1))) blackCount++;
                
                // Increment the count for this specific blackCount
                result[blackCount]++;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int rows = 3, cols = 3;
        int[][] black = {{0, 0}, {0, 1}, {1, 0}};
        long[] output = solution(rows, cols, black);
        
        for (long count : output) {
            System.out.print(count + " ");
        }
        // Expected Output: [1, 2, 0, 1, 0]
    }
}
