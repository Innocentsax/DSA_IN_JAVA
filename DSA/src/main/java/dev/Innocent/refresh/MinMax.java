package dev.Innocent.refresh;

public class MinMax {

    public static void main(String[] args) {
        int[] numbers = {5, 8, 2, 10, 3, 7};

        findMaxMin(numbers);
    }

    public static void findMaxMin(int[] numbers){
        int max = numbers[0];
        int min = numbers[0];

        for(int i = 1; i < numbers.length; i++){
            // This is to check for the max value
            if(numbers[i] > max){
                max = numbers[i];
            }
            if(numbers[i] < min){
                min = numbers[i];
            }
        }

        System.out.println("Maximum element: " + max);
        System.out.println("Minimum element: " + min);
    }
}
