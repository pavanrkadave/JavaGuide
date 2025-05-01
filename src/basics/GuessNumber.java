package basics;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {
        int guess;
        int attempts = 0;
        int min;
        int max;

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                -----------------------------------
                -- Welcome to the Guessing Game! --
                -----------------------------------
                """);

        System.out.println("""
                Please enter the range for the guessing game.
                The minimum number should be less than the maximum number.
                """);
        do {
            System.out.print("Enter the minimum number: ");
            min = scanner.nextInt();
            System.out.print("Enter the maximum number: ");
            max = scanner.nextInt();
            if (min >= max) {
                System.out.println("Invalid range! Please ensure the minimum is less than the maximum.");
            }
        } while (min >= max);
        System.out.println("Thank you! Let's start the game.");

        int numberToGuess = random.nextInt(min, max + 1);
        System.out.printf("Guess a number between %d-%d:%n", min, max);
        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;
            if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.printf("""
                        --------------------------------------
                        -- Congratulations! You guessed it! --
                        -- It took you %d attempts.          --
                        --------------------------------------
                        """, attempts);
            }
        } while (guess != numberToGuess);

        scanner.close();
    }
}
