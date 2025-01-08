package dev.Innocent.Section7.Collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hashing {
    public static void main(String[] args) {
        String aText = "Hello";
        String bText = "Hello";
        String cText = String.join("l", "He", "lo");
        String dText = "He".concat("llo");
        String eText = "hello";

        List<String> hellos = Arrays.asList(aText, bText, cText, dText, eText);
        hellos.forEach(s -> System.out.println(s + ": " + s.hashCode()));

        Set<String> mySet = new HashSet<>(hellos);

        System.out.println("mySet = " + mySet);
        System.out.println("# of elements = " + mySet.size());

        for(String setValue : mySet){
            System.out.print(setValue + ": ");
            for (int i = 0; i < hellos.size(); i++){
                if(setValue == hellos.get(i)){
                    System.out.println(i + ", ");
                }
            }
            System.out.println(" ");
        }
    }
}
