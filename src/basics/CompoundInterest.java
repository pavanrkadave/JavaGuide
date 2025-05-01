package basics;

import java.util.Scanner;

public class CompoundInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                #############################################
                #                                           #
                #       Compound Interest Calculator        #
                #                                           #
                #############################################
                """);
        double principalAmount;
        double rateOfInterest;
        int timesCompounded;
        int years;
        double amount;

        System.out.print("Enter the principal amount: ");
        principalAmount = scanner.nextDouble();

        System.out.print("Enter the rate of interest (in %): ");
        rateOfInterest = scanner.nextDouble() / 100;

        System.out.println("""
                How many times is the interest compounded per year?
                1. Annually (1)
                2. Semi-Annually (2)
                3. Quarterly (4)
                4. Monthly (12)
                """);
        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> timesCompounded = 1; // Annually
            case 2 -> timesCompounded = 2; // Semi-Annually
            case 3 -> timesCompounded = 4; // Quarterly
            case 4 -> timesCompounded = 12; // Monthly
            default -> {
                System.out.println("Invalid choice. Defaulting to Annually.");
                timesCompounded = 1;
            }
        }

        System.out.print("Enter the # of years: ");
        years = scanner.nextInt();

        amount = principalAmount * Math.pow(1 + rateOfInterest / timesCompounded, timesCompounded * years);

        System.out.println("\n");
        System.out.println("""
                #############################################
                #                                           #
                #             Compound Interest             #
                #                                           #
                #############################################
                """);
        System.out.printf("Principal Amount: $%.2f%n", principalAmount);
        System.out.printf("Rate of Interest: %.2f%%%n", rateOfInterest * 100);
        System.out.printf("Times Compounded: %d times per year%n", timesCompounded);
        System.out.printf("Number of Years: %d years%n", years);
        System.out.printf("Total Amount after %d years: $%.2f%n", years, amount);
        System.out.printf("Compound Interest Earned: $%.2f%n", amount - principalAmount);
    }
}
