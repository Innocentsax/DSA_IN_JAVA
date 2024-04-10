package dev.Innocent.StringsInJava;

public class Patterns {
    public static void main(String[] args) {
        pattern9(4);
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

    static void pattern7(int n) {
        for (int row = 1; row <= n; row++) {
            for (int space = 0; space < n-row; space++) {
                System.out.print("  ");
            }
            for (int col = row; col >= 1 ; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= row ; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static void pattern8(int n) {
        for (int row = 1; row <= 2*n; row++) {
            int totalNumberCol = row > n ? 2*n - row : row;

            for (int space = 0; space < n-totalNumberCol; space++) {
                System.out.print("  ");
            }
            for (int col = totalNumberCol; col >= 1 ; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= totalNumberCol ; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static void pattern9(int n){
        int originalN = n;
        n = 2 * n;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                int atEveryIndex = originalN - Math.min(Math.min(row, col),
                        Math.min(n - row, n - col));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }
}
