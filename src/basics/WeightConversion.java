package basics;

import java.util.Scanner;

public class WeightConversion {
    public static void main(String[] args) {
        System.out.println("""
                #############################################
                #                                           #
                #             Weight Conversion             #
                #                                           #
                #############################################
                """);
        double weight;
        double convertedWeight;
        int choice;

        System.out.println("""
                Choose the conversion type:
                1. Pounds to Kilograms
                2. Kilograms to Pounds
                """);
        System.out.print("Enter your choice (1-2): ");
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.print("Enter weight in pounds: ");
                weight = scanner.nextDouble();
                convertedWeight = weight * 0.45359237;
                System.out.printf("Weight in kilograms: %.2f kg%n", convertedWeight);
            }
            case 2 -> {
                System.out.print("Enter weight in kilograms: ");
                weight = scanner.nextDouble();
                convertedWeight = weight / 0.45359237;
                System.out.printf("Weight in pounds: %.2f lbs%n", convertedWeight);
            }
            default -> System.out.println("Invalid choice.");
        }
    }
}
