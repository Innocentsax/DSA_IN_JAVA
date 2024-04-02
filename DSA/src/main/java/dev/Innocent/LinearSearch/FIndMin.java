package dev.Innocent.LinearSearch;

public class FIndMin {
    public static void main(String[] args) {
        int[] arr = {18, 12, 3, 14, 5};
        System.out.println(max(arr));
    }
    static int min(int[] arr){
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < ans){
                ans = arr[i];
            }
        }
        return ans;
    }
    
    static int max(int[] arr){
//        int ans = arr[0];
        if(arr.length == 0){
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > arr[0]){
                arr[0] = arr[i];
            }
        }
        return arr[0];
    }
}
