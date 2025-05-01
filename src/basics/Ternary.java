package basics;

import java.util.Scanner;

public class Ternary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours;
        System.out.print("Enter hours (0-23): ");
        hours = scanner.nextInt();
        String timeOfDay = hours < 12 ? "AM" : "PM";
        System.out.println("Time of day: " + timeOfDay);
    }
}
