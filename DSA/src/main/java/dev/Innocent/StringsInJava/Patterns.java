package dev.Innocent.StringsInJava;

public class Patterns {
    public static void main(String[] args) {
        pattern6(4);
    }
    static void pattern1(int n){
        for (int row = 1; row <= n; row++) {
            // for every row, run the col
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            // When one row is printed, we need to add a newline
            System.out.println();
        }
    }

    static void pattern2(int n){
        for (int row = 1; row <= n; row++) {
            // for every row, run the col
            for (int col = 1; col <= n; col++) {
                System.out.print("* ");
            }
            // When one row is printed, we need to add a newline
            System.out.println();
        }
    }
    static void pattern3(int n){
        for (int row = 1; row <= n; row++) {
            // for every row, run the col
            for (int col = 1; col <= n -row + 1; col++) {
                System.out.print("* ");
            }
            // When one row is printed, we need to add a newline
            System.out.println();
        }
    }

    static void pattern4(int n){
        for (int row = 1; row <= n; row++) {
            // for every row, run the col
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            // When one row is printed, we need to add a newline
            System.out.println();
        }
    }

    static void pattern5(int n){
        for (int row = 1; row < 2 * n; row++) {
            int totalNumberCol = row > n ? 2*n - row : row;
            for (int col = 1; col <= totalNumberCol; col++) {
                System.out.print("* ");
            }
            // When one row is printed, we need to add a newline
            System.out.println();
        }
    }

    static void pattern6(int n){
        for (int row = 1; row < 2 * n; row++) {
            int totalNumberCol = row > n ? 2*n - row : row;

            // Number of spaces
            int noOfSpace = n - totalNumberCol;
            for (int s = 0; s < noOfSpace; s++) {
                System.out.print(" ");
            }

            for (int col = 1; col <= totalNumberCol; col++) {
                System.out.print("* ");
            }
            // When one row is printed, we need to add a newline
            System.out.println();
        }
    }
}
