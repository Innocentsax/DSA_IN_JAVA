package dev.Innocent.Section7.ArrayAndArrayList;

import java.util.LinkedList;
import java.util.Scanner;

record Place(String name, int distance){
    @Override
    public String toString() {
        return String.format("%s (%d)", name, distance);
    }
}

public class LinkedListChallenge {
    public static void main(String[] args) {
        LinkedList<Place> placesToVisit = new LinkedList<>();

        Place place = new Place("Akin", 222);
        addPlace(placesToVisit, place);
        addPlace(placesToVisit, new Place("alkin", 222));
        addPlace(placesToVisit, new Place("Bouy", 50));
        addPlace(placesToVisit, new Place("KKkin", 22));
        addPlace(placesToVisit, new Place("akn", 202));

        placesToVisit.addFirst(new Place("allkin", 0));
        System.out.println(placesToVisit);

        var iterator = placesToVisit.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean quitLoop = false;
        boolean forward = true;

        printMenu();

        while (!quitLoop){
            System.out.println("Enter value ");
            String menuItem = scanner.nextLine().toUpperCase().substring(0,1);

            switch (menuItem){
                case "F":
                    System.out.println("User wants to go forward ");
                    break;
                case "B":
                    System.out.println("User wants to go Backward ");
                    break;
                case "L":
                    System.out.println("User wants view the List ");
                    break;
                case "M":
                    printMenu();
                    break;
                default:
                    quitLoop = true;
                    break;
            }
        }
    }

    private static void addPlace(LinkedList<Place> list, Place place){
        if(list.contains(place)){
            System.out.println("Found Duplicate " + place);
            return;
        }
        for(Place p : list){
            if(p.name().equalsIgnoreCase(place.name())){
                System.out.println("Found Duplicate " + place.name());
                return;
            }
        }
        int matchedIndex = 0;
        for(var listPlace : list){
            if(place.distance() < listPlace.distance()){
                list.add(matchedIndex, place);
                return;
            }
            matchedIndex++;
        }
        list.add(place);
    }

    public static void printMenu(){
        System.out.println("""
                Available actions (Select word or letter):
                (F)orward
                (B)arkward
                (L)ist Places
                (M)enu
                (Q)uit""");
    }
}
