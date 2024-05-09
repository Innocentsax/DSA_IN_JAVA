package dev.Innocent.Assignment.Arrays;

import java.util.HashSet;
import java.util.Set;

class Pangram {
    public static void main(String[] args) {
        String sentence = "onrcsnlxckptsxffbyswujpamfltvmdoxovggepknmtacrjkkorjgvgtgaiaudspnpxkwikevmjeephhiyvnoymjwjfopovscbefecnoytjxfwasabwohqujwowmakpyuuqvgfab";
        System.out.println(checkIfPangram(sentence));
    }
    public static boolean checkIfPangram(String sentence) {
        Set<Character> alphabet = new HashSet<>();

        // Add all character from 'a' to 'z' in hashset
        for (int i = 'a'; i <= 'z'; i++) {
            alphabet.add((char) i);
        }
        System.out.println(alphabet);
        // Remove every character and check if set becomes empty at any point in time
        for (int i = 0; i < sentence.length(); i++) {
            alphabet.remove(sentence.charAt(i));
            if(alphabet.isEmpty()){
                return true;
            }
        }
        return false;
    }
}