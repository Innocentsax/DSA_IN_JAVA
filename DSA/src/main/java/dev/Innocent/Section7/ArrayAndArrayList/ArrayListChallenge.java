package dev.Innocent.Section7.ArrayAndArrayList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ArrayListChallenge {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean flag = true;
        ArrayList<String> groceries = new ArrayList<>();
        while(flag){
            printAction();
            switch (Integer.parseInt(scanner.nextLine())){
                case 1 -> addItem(groceries);
                case 2 -> removeItem(groceries);
                default -> flag = false;
            }
            groceries.sort(Comparator.naturalOrder());
            System.out.println(groceries);
        }
    }

    private static void addItem(ArrayList<String> groceries){
        System.out.println("Add item(s) [Separate item by comma]:");
        String[] items = scanner.nextLine().split(",");
//        groceries.addAll(List.of(items));

        for(String i : items){
            String trimmed = i.trim();
            if(groceries.indexOf(trimmed) < 0){
                groceries.add(trimmed);
            }
        }
    }

    private static void removeItem(ArrayList<String> groceries){
        System.out.println("Add item(s) [Separate item by comma]:");
        String[] items = scanner.nextLine().split(",");

        for(String i : items){
            String trimmed = i.trim();
            groceries.remove(trimmed);
        }
    }

    private static void printAction(){
        String textBlock = """
                Available option:
                
                0 - to Shutdown
                
                1 - to add item(s) to list (comma delimited list)
                
                2 - to remove any item (comma delimited list)
                
                Enter a number for which action u wanna do:""";

        System.out.print(textBlock + " ");
    }
}
