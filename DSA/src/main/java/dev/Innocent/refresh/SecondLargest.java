package dev.Innocent.refresh;

public class SecondLargest {
    public static void main(String[] args) {
        int[] number = {5, 8, 2, 10, 3, 7};

        int result = findSecondLargest(number);
        System.out.println(result);
    }

    private static int findSecondLargest(int[] arr){
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int num : arr){
            if(num > first){
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }
        return second;
    }
}
