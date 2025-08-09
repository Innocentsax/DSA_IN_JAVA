package dev.Innocent.Section8.ConcurrencyAndMultithreading.ThreadChallenge;

public class SecondThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 9; i++) {
            System.out.println(" Innocent ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
