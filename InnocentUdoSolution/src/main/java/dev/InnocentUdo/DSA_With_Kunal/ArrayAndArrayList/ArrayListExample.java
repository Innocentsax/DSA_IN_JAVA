package dev.InnocentUdo.DSA_With_Kunal.ArrayAndArrayList;


import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>(10);

        // Populating the list
        list.add(23);
        list.add(24);
        list.add(25);
        list.add(26);
        list.add(27);

        list.set(0, 29); // using the set keyword
        list.remove(0); // using the remove key word
        System.out.println(list);
        System.out.println(list.contains(25)); // using the contain method
        System.out.println(list.contains(29));


        // taking input using for loop
        for (int i = 0; i < 5; i++) {
            list.add(in.nextInt());
            System.out.println(list.get(i)); // pass index here
        }
        System.out.println(list);
    }
}
