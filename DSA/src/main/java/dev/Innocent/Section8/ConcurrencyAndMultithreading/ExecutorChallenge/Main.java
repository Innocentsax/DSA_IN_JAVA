package dev.Innocent.Section8.ConcurrencyAndMultithreading.ExecutorChallenge;

import java.util.Random;

record Order(long orderId, String item, int qty) {
};

public class Main {

    private static final Random random = new Random();

    public static void main(String[] args) {

        ShoeWarehouse warehouse = new ShoeWarehouse();
        Thread producerThread = new Thread(() -> {
            for (int j = 0; j < 10; j++) {
                warehouse.receiveOrder(new Order(
                        random.nextLong(1000000, 9999999),
                        ShoeWarehouse.PRODUCT_LIST[random.nextInt(0, 5)],
                        random.nextInt(1, 4)));
            }
        });
        producerThread.start();
    }

    private static Order generateOrder(){
        return new Order(
                random.nextLong(1000000, 9999999),
                ShoeWarehouse.PRODUCT_LIST[random.nextInt(0, 5)],
                random.nextInt(1, 4));
    }
}
