package dev.Innocent;

import java.util.Scanner;

public class fibo {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();

        int a = 0;
        int b = 1;
        int c = 2;

        while(c <= n) {
            int next = b;
            b = b + a;
            a = next;
            c++;
        }
        System.out.println(b);
    }
}
