package dev.InnocentUdo.DSA_With_Kunal.ArrayAndArrayList;

public class Max {
    public static void main(String[] args) {
        int[] arr = {1, 3, 23, 9, 19};
        System.out.println(maxRange(arr, 1, 4));

    }
    static int max(int[] arr) {

        if(arr.length == 0){
            return -1;
        }

        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

        static int maxRange(int[] arr, int start, int end) {

            if (end > start) {
                return -1;
            }
            if (arr == null) {
                return -1;
            }

            int maxVal = arr[start];
            for (int i = start; i < end; i++) {
                if (arr[i] > maxVal) {
                    maxVal = arr[i];
                }
            }
            return maxVal;
        }
}
