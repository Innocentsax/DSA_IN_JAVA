package dev.Innocent.StringsInJava;

public class Alphabet {
    public static void main(String[] args) {
//        System.out.println(alphabet(""));
        System.out.println(alphabet2());
    }

    /*
    Using String: Remember String are immutable and can not be changed nor modified. hence
    new series array is been created each time the loop runs and the new value is being added
    to a copy of the old one. leading to memory wastage.
    a, ab, abc, abcd, abcde, .... a-z

    Meaning String are immutable
     */
    static String alphabet(String series){
        for (int i = 0; i < 26; i++) {
            char alphabet = (char) ('a' + i);
            series = series + alphabet; // series += alphabet
        }
        return series;
    }


    /*
    StringBuilder are mutable, hence new object are append to the existing object
     */
    static StringBuilder alphabet2(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char alphabet = (char) ('a' + i);
            builder.append(alphabet);
        }
        return builder;
    }
}
