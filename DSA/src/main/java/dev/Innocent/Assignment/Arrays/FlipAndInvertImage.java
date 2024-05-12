package dev.Innocent.Assignment.Arrays;

import java.util.Arrays;

// https://leetcode.com/problems/flipping-an-image/solutions/4978351/beats-100-time-o-n-m-space-o-1-java-0ms-easy-explained/
class FlipAndInvertImage {
    public static void main(String[] args) {
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        System.out.println(Arrays.deepToString(flipAndInvertImage1(image)));
    }
    public static int[][] flipAndInvertImage(int[][] image) {
        for(int[] row : image){
            int i = 0, r = row.length - 1;
            while(i <= r){
                int temp = row[i];
                row[i++] = row[r] ^1;
                row[r--] = temp ^1;
            }
        }
        return image;
    }

    /*
    Using the second method
    @Approach
    - Iterate through each row of the image array.
    - For each row, initialize two pointers j and k pointing to the start and end of the row, respectively.
    - While j is less than or equal to k, swap the elements at indices
    j and k of the current row and invert them using the XOR (^) operation with 1.
    - Increment j and decrement k to move towards the center of the row.
    - Repeat steps 3-4 until j becomes greater than k, indicating that the entire row has been processed.
    - After processing all rows, return the modified image array.
     */
    public static int[][] flipAndInvertImage1(int[][] image) {
        // Iterate through each row of the image array
        for (int i = 0; i < image.length; i++) {
            // Initialize 2 pointers for flipping
            int j = 0, k = image[i].length - 1;
            // Flip and invert elements until j <= k
            while (j <= k){
                // Store element at index j
                int temp = image[i][j];
                // Invert and swap elements at indices j and k
                image[i][j] = image[i][k] ^ 1;
                image[i][k] = temp ^ 1;

                // Move j towards center & Move k towards center
                j++;
                k--;
            }
        }
        // Return the modified image array
        return image;
    }
}