package dev.Innocent.refresh;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(palindrome("abe"));
    }

    private static boolean palindrome(String value){
        char[] a = value.toCharArray();
        int start = 0;
        int end = value.length() - 1;

        while (start < end){
            if(a[start] != a[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
