package dev.Innocent.Intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dxc {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        java6Version(names);

        java8Version(names);

        System.out.println(palin("madam"));

    }

    public static void java6Version(List<String> names){
        List<String> filtered = new ArrayList<>();
        for(String name : names){
            if(!name.startsWith("A")){
                filtered.add(name);
            }
        }
        System.out.println("Name : " + filtered);
    }

    public static void java8Version(List<String> names){
        List<String> filtered = names.stream().filter(name -> !name.startsWith("A")).toList();
        System.out.println("Name: " + filtered);
    }
    // madam
    public static boolean palin(String word){
        char[] s = word.toCharArray();
        int b = 0;
        int e = s.length - 1;

        while (b < e){
            if(s[b] != s[e]){
                return false;
            }
            b++;
            e--;
        }
        return true;
    }


}
// Create a class in Java 6 version and Java 8 version. Filter out names that start with "A"
