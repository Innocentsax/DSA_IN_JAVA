package dev.Innocent.Section8.ConcurrencyAndMultithreading.ThreadChallenge;

public class Main {
    public static void main(String[] args) {
        System.out.print("Main Thread state here");
        try {
            System.out.println("get me some space");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SecondThread secondThread = new SecondThread();
        secondThread.start();


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 8; i++) {
                    System.out.println(" Udo ");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread toThread = new Thread(runnable);
        toThread.start();
    }
}
