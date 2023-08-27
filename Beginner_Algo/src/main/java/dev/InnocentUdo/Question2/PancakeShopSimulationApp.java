package dev.InnocentUdo.Question2;

import java.util.Random;

public class PancakeShopSimulationApp {

    public static void main(String[] args) {
        runPancakeShopSimulation();
    }

    public static void runPancakeShopSimulation() {
        final int MAX_PANCAKES_PER_BATCH = 12;
        final int MAX_PANCAKES_PER_USER = 5;
        final int MAX_USERS = 3;
        final int PRODUCTION_TIME_IN_SEC = 30;

        Random random = new Random();

        int totalPancakesMade = 0;
        int totalPancakesEaten = 0;
        int totalOrdersNotMet = 0;
        int totalPancakesWasted = 0;

        for (int i = 0; i < PRODUCTION_TIME_IN_SEC; i += PRODUCTION_TIME_IN_SEC) {
            int pancakesMade = random.nextInt(MAX_PANCAKES_PER_BATCH + 1);
            int[] pancakeOrders = new int[MAX_USERS];
            int remainingPancakes = pancakesMade;

            for (int j = 0; j < MAX_USERS; j++) {
                pancakeOrders[j] = random.nextInt(MAX_PANCAKES_PER_USER + 1);
                if (pancakeOrders[j] > remainingPancakes) {
                    pancakeOrders[j] = remainingPancakes;
                }
                remainingPancakes -= pancakeOrders[j];
            }

            totalPancakesMade += pancakesMade;

            for (int j = 0; j < MAX_USERS; j++) {
                totalPancakesEaten += pancakeOrders[j];
            }

            if (remainingPancakes > 0) {
                totalPancakesWasted += remainingPancakes;
            }

            if (remainingPancakes > 0 || totalPancakesEaten > (MAX_USERS * MAX_PANCAKES_PER_USER)) {
                totalOrdersNotMet++;
            }

            System.out.println("Starting Time: " + i + " seconds");
            System.out.println("Ending Time: " + (i + PRODUCTION_TIME_IN_SEC) + " seconds");
            System.out.println("Number of Pancakes Made: " + pancakesMade);
            System.out.println("Number of Pancakes Eaten: " + totalPancakesEaten);
            System.out.println("Shopkeeper Met User's Needs: " + (remainingPancakes == 0));
            System.out.println("Total Number of Wasted Pancakes: " + totalPancakesWasted);
            System.out.println("Total Number of Orders Not Met: " + totalOrdersNotMet);
            System.out.println("------------------------------");
        }
    }
}

