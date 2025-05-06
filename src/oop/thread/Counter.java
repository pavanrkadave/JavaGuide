package oop.thread;

public class Counter implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
            if (i == 5) {
                System.out.println("\nTime's up!");
                System.exit(0);
            }
        }

    }
}
