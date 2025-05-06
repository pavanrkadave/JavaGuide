package oop.timer;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            int counter = 3;

            @Override
            public void run() {
                counter--;
                System.out.println("Hello World");
                if (counter == 0) {
                    System.out.println("Goodbye");
                    timer.cancel();
                }
            }


        };

        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}
