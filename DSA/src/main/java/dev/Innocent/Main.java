package dev.Innocent;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            if(i % 3 == 0) {
                continue;
            }
            else if(i == 8) {
                break;
            }
            else {
                sum += i;
                System.out.print(i + " ");
            }
            System.out.print(" = " + sum);
        }
    }

}