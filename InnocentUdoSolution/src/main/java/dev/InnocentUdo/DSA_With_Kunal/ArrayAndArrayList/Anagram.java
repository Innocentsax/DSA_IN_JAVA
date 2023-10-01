package dev.InnocentUdo.DSA_With_Kunal.ArrayAndArrayList;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {
        String t = "Innocent";
        String s = "nagaram";

        System.out.println(isAnagram2(s, t));
    }
    public static boolean isAnagram(String s, String t){
        Map<Character, Integer> first = new HashMap<>();
        Map<Character, Integer> second = new HashMap<>();

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        for(int i = 0; i < arr1.length; i++){
            if(first.get(arr1[i])== null){
                first.put(arr1[i], 1);
            }
            else{
                Integer c = (int) first.get(arr1[i]);
                first.put(arr1[i], ++c);
            }
        }
        for(int j = 0; j < arr2.length; j++){
            if(second.get(arr2[j])== null) {
                second.put(arr2[j], 1);
            }else{
                Integer d = (int) second.get(arr2[j]);
                second.put(arr2[j], ++d);
            }
        }
        if(first.equals(second))
            return true;
        else
            return false;
    }

    public static boolean isAnagram2(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] alphb = new int[26];
        for(int i = 0; i < s.length(); i++){
            alphb[s.charAt(i) - 'a']++;
            alphb[t.charAt(i) - 'a']--;
        }
        for(int n : alphb){
            if(n != 0){
                return false;
            }
        }
        return true;
    }
}
