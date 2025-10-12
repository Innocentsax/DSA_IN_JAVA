package dev.Innocent.refresh;

public class SecondLargest {
    public static void main(String[] args) {

    }

    private static void findSecondLargest(int[] arr){
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int num : arr){
            if(num > first){
                second = first;
                first = num;
            }
        }
    }
}
