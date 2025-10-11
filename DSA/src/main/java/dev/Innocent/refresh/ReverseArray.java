package dev.Innocent.refresh;

public class ReverseArray {

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6};

        reverseArray(numbers);
        for(int num : numbers){
            System.out.print(num + " ");
        }
    }

    private static void reverseArray(int[] array){
        int start = 0;
        int end = array.length - 1;

        while (start < end){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }
    }
}
