package oop.enums;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a day of week: ");
            String input = scanner.nextLine().toUpperCase();

            Day day = Day.valueOf(input);

            switch (day) {
                case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> System.out.println("It's a weekday.");
                case SATURDAY, SUNDAY -> System.out.println("It's a weekend.");
                default -> System.out.println("Invalid day.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid day entered.");
        }
    }
}
