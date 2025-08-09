package dev.Innocent.Section8.ConcurrencyAndMultithreading.ThreadChallenge;

public class SecondThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 9; i+=2) {
            System.out.println(" oddThread: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("OddThread interrupted!");
                break;
            }
        }
    }
}
