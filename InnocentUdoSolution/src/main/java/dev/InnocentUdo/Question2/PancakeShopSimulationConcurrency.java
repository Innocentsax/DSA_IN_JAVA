package dev.InnocentUdo.Question2;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class PancakeShopSimulationConcurrency {

    public static void main(String[] args) {
        runSimulation();
    }

    public static void runSimulation() {
        final int MAX_USERS = 3;
        final int MAX_PANCAKES_PER_USER = 5;
        final int MAX_PANCAKES_PER_BATCH = 12;
        final int PRODUCTION_TIME_IN_SEC = 30;

        Random random = new Random();
        AtomicInteger totalPancakesProduced = new AtomicInteger(0);
        AtomicInteger totalPancakesConsumed = new AtomicInteger(0);
        AtomicInteger totalUnfulfilledOrders = new AtomicInteger(0);
        AtomicInteger totalWastedPancakes = new AtomicInteger(0);

        for (int time = 0; time < PRODUCTION_TIME_IN_SEC; time += PRODUCTION_TIME_IN_SEC) {
            int pancakesProduced = random.nextInt(MAX_PANCAKES_PER_BATCH + 1);
            int[] pancakeOrders = new int[MAX_USERS];
            AtomicInteger remainingPancakes = new AtomicInteger(pancakesProduced);

            for (int userIndex = 0; userIndex < MAX_USERS; userIndex++) {
                pancakeOrders[userIndex] = random.nextInt(MAX_PANCAKES_PER_USER + 1);
                if (pancakeOrders[userIndex] > remainingPancakes.get()) {
                    pancakeOrders[userIndex] = remainingPancakes.get();
                }
                remainingPancakes.addAndGet(-pancakeOrders[userIndex]);
            }

            totalPancakesProduced.addAndGet(pancakesProduced);

            for (int userIndex = 0; userIndex < MAX_USERS; userIndex++) {
                totalPancakesConsumed.addAndGet(pancakeOrders[userIndex]);
            }

            if (remainingPancakes.get() > 0) {
                totalWastedPancakes.addAndGet(remainingPancakes.get());
            }

            if (remainingPancakes.get() > 0 || totalPancakesConsumed.get() > (MAX_USERS * MAX_PANCAKES_PER_USER)) {
                totalUnfulfilledOrders.incrementAndGet();
            }

            System.out.println("Starting Time: " + time + " seconds");
            System.out.println("Ending Time: " + (time + PRODUCTION_TIME_IN_SEC) + " seconds");
            System.out.println("Number of Pancakes Produced: " + pancakesProduced);
            System.out.println("Number of Pancakes Consumed: " + totalPancakesConsumed);
            System.out.println("Shopkeeper Met User's Orders: " + (remainingPancakes.get() == 0));
            System.out.println("Total Number of Wasted Pancakes: " + totalWastedPancakes);
            System.out.println("Total Number of Unfulfilled Orders: " + totalUnfulfilledOrders);
            System.out.println("End of Simulation");
        }
    }
}

