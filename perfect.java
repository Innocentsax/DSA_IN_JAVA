/*
You might know some pretty large perfect squares. But what about the next one?

Create a method that finds the next integral perfect square after the one passed as a parameter. Recall that an integral perfect square is an integer n such that sqrt(n) is also an integer.

If the parameter is itself not a perfect square, than -1 should be returned. You may assume the parameter is positive.

Examples
Input	Output	Comments
121	144	
625	676	
114	-1	Since 114 is not a perfect square
Documentation
findNextSquare(num)
Parameters:
num: long or int
An integer greater than 0.

Guaranteed Constraints:
The input will always be an integer, it will never be null or undefined.
The input integer will always be greater than 0 (no negative inputs).
Returns: long or int
If the input is a perfect square, return the next perfect square.

If it is not a perfect square, return -1. */

public class NextPerfectSquareFinder {
    public static long findNextSquare(long num) {
        long sqrt = (long) Math.sqrt(num);
        if (sqrt * sqrt == num) {
            // The input num is a perfect square
            long nextSqrt = sqrt + 1;
            return nextSqrt * nextSqrt;
        } else {
            // The input num is not a perfect square
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(findNextSquare(121)); // Output: 144
        System.out.println(findNextSquare(625)); // Output: 676
        System.out.println(findNextSquare(114)); // Output: -1
    }
}
