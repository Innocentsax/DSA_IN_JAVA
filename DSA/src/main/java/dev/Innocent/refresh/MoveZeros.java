package dev.Innocent.refresh;

public class MoveZeros {
    public static void main(String[] args) {
        int[] num = {1, 0, 3, 0, 8, 0, 7};

        moveZerosToEnd(num);

        for(int n : num){
            System.out.print(n + " ");
        }
    }

    // Move all zeros to the end of an array.
    private static void moveZerosToEnd(int[] zeros){
        int index = 0;

        for(int i = 0; i < zeros.length; i++){
            if(zeros[i] != 0){
                zeros[index] = zeros[i];
                index++;
            }
        }
    }
}
