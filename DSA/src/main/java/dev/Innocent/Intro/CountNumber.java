package dev.Innocent.Intro;

public class CountNumber {
    // Q. How many numbers of 5 appears in this list
    public static void main(String[] args) {
        int n = 43884889;
        int counter = 0;

        while (n > 0){
            int rem = n % 10;
            if(rem == 8){
                counter++;
            }
            n = n / 10;
        }
        System.out.println(counter);
    }
}
