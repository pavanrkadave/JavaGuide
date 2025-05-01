package basics;

import java.util.Scanner;

public class Loops {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("""
                --------------------------------
                --    Countdown Timer App     --
                --------------------------------
                """);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the countdown time in seconds: ");
        int start = scanner.nextInt();

        for (int i = start; i >= 0; i--) {
            if (i < 5) {
                System.out.printf("%d..\uD83E\uDD29", i);
            } else {
                System.out.printf("%d..", i);
            }
            Thread.sleep(1000); // Sleep for 1 second
        }
        System.out.println("Time's up! \uD83C\uDF89");
    }
}
