package dev.Innocent.Section8.ConcurrencyAndMultithreading.Thread;

import dev.Innocent.Section8.ConcurrencyAndMultithreading.ThreadChallenge.SecondThread;

public class CustomThread extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 5; i++){
            System.out.print(" 1 ");
            try{
                Thread.sleep(500); // Adding a 1-second delay between each count
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
