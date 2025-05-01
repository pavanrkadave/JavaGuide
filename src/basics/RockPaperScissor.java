package basics;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        String[] choices = {"rock", "paper", "scissor"};
        String playerChoice;
        String computerChoice;
        String playAgain = "yes";

        do {
            printFormattedMessage("Welcome to Rock Paper Scissor!");
            System.out.print("Enter your move (rock, paper, scissor): ");
            playerChoice = scanner.nextLine().toLowerCase();

            if (!playerChoice.equals("rock") && !playerChoice.equals("paper") && !playerChoice.equals("scissor")) {
                System.out.println("Invalid move");
                continue;
            }

            computerChoice = choices[random.nextInt(3)];
            System.out.println("Computer: " + computerChoice);

            if (playerChoice.equals(computerChoice)) {
                printFormattedMessage("It's a tie!");
            } else if ((playerChoice.equals("rock") && computerChoice.equals("scissor")) || (playerChoice.equals("paper") && computerChoice.equals("rock")) || (playerChoice.equals("scissor") && computerChoice.equals("paper"))) {
                printFormattedMessage("You win!");
            } else {
                printFormattedMessage("You lose!");
            }


            System.out.print("Play again? (yes/no): ");
            playAgain = scanner.nextLine().toLowerCase();
        } while (playAgain.equals("yes"));

        printFormattedMessage("Thank you for playing!");

        scanner.close();
    }

    private static void printFormattedMessage(String message) {
        System.out.printf("""
                
                ---------------------------------------------------
                -----     %-30s     ------
                ---------------------------------------------------
                
                """, message);
    }


}
