package basics;

import java.util.Scanner;

public class Bank {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Java Banking program

        // Declare basics.Variables
        double balance = 10.99;
        boolean isRunning = true;
        int choice;

        while (isRunning) {
            //Display Menu
            System.out.println("""
                    
                    
                    ----------------------------------------------
                    --------        BANKING SYSTEM        --------
                    ----------------------------------------------
                    """);
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("----------------------------------------------");
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showBalance(balance);
                case 2 -> balance += deposit();
                case 3 -> balance -= withdraw(balance);
                case 4 -> isRunning = false;
                default -> System.out.println("INVALID INPUT");
            }

        }
        scanner.close();
    }

    static void showBalance(double balance) {

        System.out.printf("""
                
                ---------->>BALANCE<----------
                $%.2f
                ------------------------------
                
                """, balance);
    }

    static double deposit() {
        double amount;

        System.out.print("Enter amount to deposit: ");
        amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Amount cannot be negative");
            return 0;
        } else {
            return amount;
        }
    }

    static double withdraw(double balance) {
        double amount;

        System.out.print("Enter amount to withdraw: ");
        amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("INSUFFICIENT BALANCE");
            return 0;
        } else if (amount < 0) {
            System.out.println("Amount cannot be negative");
            return 0;
        } else {
            return amount;
        }
    }
}
