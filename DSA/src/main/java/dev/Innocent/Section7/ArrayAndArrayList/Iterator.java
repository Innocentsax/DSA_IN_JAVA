package dev.Innocent.Section7.ArrayAndArrayList;

import java.util.LinkedList;

public class Iterator {
    public static void main(String[] args) {

    }

    public static void testIterator(LinkedList<String> list){
        var iterator = list.listIterator();
        while(iterator.hasNext()){
            if(iterator.next().equals("Malaysia")){
                iterator.add("Malacca");
            }
        }
        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }
        System.out.println(list);
    }
}
