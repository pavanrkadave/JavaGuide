package oop.thread;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Counter counter = new Counter();
        Thread thread = new Thread(counter);
        thread.setDaemon(true);
        thread.start();

        System.out.println("You have 5 seconds to enter your name!");

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}
