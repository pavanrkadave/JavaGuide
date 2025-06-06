package basics;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------------------");
        System.out.println("-- Welcome to the basics.Calculator! --");
        System.out.println("---------------------------------");

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Enter an operator (+, -, *, /, ^): ");
        char operator = scanner.next().charAt(0);

        double result;
        switch (operator) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    return;
                }
            }
            case '^' -> result = Math.pow(num1, num2);
            default -> {
                System.out.println("Error: Invalid operator.");
                return;
            }
        }
        System.out.println("---------------------------------");
        System.out.printf("Result: %.2f", result);
        System.out.println("\n---------------------------------");

        scanner.close();
    }
}
