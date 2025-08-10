package dev.Innocent.Section8.ConcurrencyAndMultithreading.ThreadChallenge;

class EvenRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("EvenRunnnable: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("EvenRunnable interrupted");
                break;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
//        System.out.print("Main Thread state here");
//        try {
//            System.out.println("get me some space");
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        SecondThread secondThread = new SecondThread();
        Thread evenThread = new Thread(new EvenRunnable());
        secondThread.start();
        evenThread.start();



    }
}
