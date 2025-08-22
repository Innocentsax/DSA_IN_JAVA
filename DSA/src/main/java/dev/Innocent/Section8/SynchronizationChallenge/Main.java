package dev.Innocent.Section8.SynchronizationChallenge;

import java.util.Random;

record Order(long orderId, String item, int qty){

}

public class Main {

    private static final Random random = new Random();

    public static void main(String[] args) {
        ShoeWarehouse warehouse = new ShoeWarehouse();
        Thread producerThread = new Thread(() -> {
            warehouse.receiveOrder(new Order(
                    random.nextLong(1000000, 9999999),
                    ShoeWarehouse.PRODUCT_LIST[random.nextInt(0, 5)],
                    random.nextInt(1, 4)
            ));
        });
        producerThread.start();

        for (int i = 0; i < 2; i++) {
            Thread consumerThread = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    Order item = warehouse.fulfillOrder();
                }
            });
            consumerThread.start();
        }
    }
}
