package dev.Innocent.LinearSearch;

import java.util.Arrays;

public class SearchInStrings {
    public static void main(String[] args) {
        String str = "Innocent";
        char target = 'o';
        System.out.println(search2(str, target));

        System.out.println(Arrays.toString(str.toCharArray()));
    }
    static boolean search(String str, char target){
        if(str.isEmpty()){
            return false;
        }
        // Run a for loop
        for (int i = 0; i < str.length(); i++) {
            // CharAt convert a string to a single character
            if(str.charAt(i) == target){
                return true;
            }
        }
        return false;
    }

    // Using for each loop
    static boolean search2(String str, char target){
        if(str.isEmpty()){
            return false;
        }
        // Run a for each loop
        for(char ch : str.toCharArray()){
            if(ch == target){
                return true;
            }
        }
        return false;
    }
}
