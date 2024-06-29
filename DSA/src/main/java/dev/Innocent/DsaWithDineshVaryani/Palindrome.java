package dev.Innocent.DsaWithDineshVaryani;

// Given a String, the task is checked whether a given string is palindrome or not
public class Palindrome {
    public static void main(String[] args) {
        int[] num = {1,2,3,2,1};
        System.out.println(numPalindrome(num));
    }

    // For String
    private static boolean palindrome(String word){
        char[] words = word.toCharArray();
        int start = 0;
        int end = words.length - 1;
        while(start < end){
            if(words[start] != words[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    // For array of Number
    private static boolean numPalindrome(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            if(arr[start] != arr[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
