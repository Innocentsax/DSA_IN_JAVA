package dev.Innocent.refresh;

// https://leetcode.com/problems/remove-element/description/?envType=problem-list-v2&envId=array
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3}; int val = 3;
        
    }

    public static int removeElement(int[] arr, int val){
        int k = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != val){
                arr[k] = arr[i];
                k++;
            }
        }
        return k;
    }
}
