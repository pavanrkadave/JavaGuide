package oop.multithread;

public class Main {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new Counter("PING"));
        Thread thread2 = new Thread(new Counter("PONG"));

        System.out.println("GAME START");

        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main Thread was interrupted" + e.getMessage());
        }

        System.out.println("GAME OVER");
    }
}
