/*
We are tracking down our rogue agent and she travels from place to place to avoid being tracked. Each of her travels are based on a list of itineraries in an unusual or incorrect order. The task is to determine the complete route she will take.

You are given an array of routes containing her travel itineraries. Convert this into a complete, in-order list of the places she will travel.

Specification
Challenge.findRoutes(routes)
Parameters
routes: List<String[]> - Array of itineraries

Return Value
String - An ordered list or destinations

Constraints
All inputs have at least one valid, complete route


PSEUDO CODE:
Create a HashMap to store the mapping of each place to its next destination.
Iterate through the provided routes and populate the HashMap.
Find the starting point, which is the place that doesn't appear as a destination in the HashMap.
Follow the destinations in the HashMap starting from the starting point to create the complete route.
*/

import java.util.*;

public class Challenge {
    public static String findRoutes(ArrayList<ArrayList<String>> routes) {
        HashMap<String, String> destinations = new HashMap<>();

        // Populate the destinations HashMap
        for (ArrayList<String> route : routes) {
            String from = route.get(0);
            String to = route.get(1);
            destinations.put(from, to);
        }

        // Find the starting point
        String currentPlace = null;
        for (String place : destinations.keySet()) {
            if (!destinations.containsValue(place)) {
                currentPlace = place;
                break;
            }
        }

        // Build the route
        StringBuilder routeBuilder = new StringBuilder();
        while (currentPlace != null) {
            routeBuilder.append(currentPlace);
            routeBuilder.append(" -> ");
            currentPlace = destinations.get(currentPlace);
        }

        // Remove the last " -> " from the route
        if (routeBuilder.length() > 4) {
            routeBuilder.setLength(routeBuilder.length() - 4);
        }

        return routeBuilder.toString();
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> routes = new ArrayList<>();
        routes.add(new ArrayList<>(Arrays.asList("A", "B")));
        routes.add(new ArrayList<>(Arrays.asList("B", "C")));
        routes.add(new ArrayList<>(Arrays.asList("C", "D")));

        String route = findRoutes(routes);
        System.out.println(route); // Output: A -> B -> C -> D
    }
}


