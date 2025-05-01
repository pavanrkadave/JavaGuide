package basics;

import java.util.Random;
import java.util.Scanner;

public class SlotMachine {
    public static void main(String[] args) {
        // Java Slot Machine

        // Declare basics.Variables
        Scanner scanner = new Scanner(System.in);
        int balance = 100;
        int bet;
        int payout;
        String[] row;
        String playAgain = "Y";

        // Display a Welcome message
        printFormattedMessage(true, false, "Welcome to JAVA Slots!", "Symbols: \uD83C\uDF52 \uD83C\uDF49 \uD83C\uDF4B \uD83D\uDD14 ⭐");

        // Play if BALANCE > 0
        while (balance > 0) {

            // Enters BET Amount
            printFormattedMessage(false, false, "Current Balance: $ " + balance);
            System.out.print("Place your bet amount: ");
            bet = scanner.nextInt();
            scanner.nextLine();

            // Verify if BET > BALANCE
            if (bet > balance) {
                System.out.println("INSUFFICIENT BALANCE");
                continue;
            } else if (bet <= 0) {
                // Verify If BET > 0
                System.out.println("Bet must be greater than 0");
            } else {
                // Subtract BET from BALANCE
                balance -= bet;
            }

            // Spin ROW
            row = spinRow();

            // Print ROW
            printFormattedMessage(true, true
                    , "Spinning...", String.join(" | ", row));

            // Get PAYOUT
            payout = getPayout(row, bet);
            if (payout > 0) {
                printFormattedMessage(false, false, "You Won $" + payout + " !! \uD83E\uDD73");
                balance += payout;
            } else {
                printFormattedMessage(false, false, "Sorry you lost this round! \uD83E\uDD72");
            }

            // Ask to play again
            System.out.println("Do you want to play again? (Y/N): ");
            playAgain = scanner.nextLine().toUpperCase();

            if (!playAgain.equals("Y")) {
                break;
            }
        }


        printFormattedMessage(true, false, "GAME OVER!!", "Your Final Balance: $ " + balance);
        // Display an exit message

    }

    private static int getPayout(String[] row, int bet) {
        if (row[0].equals(row[1]) && row[0].equals(row[2])) {
            return switch (row[0]) {
                case "🍒" -> bet * 5;
                case "🍉" -> bet * 10;
                case "🍋" -> bet * 20;
                case "🔔" -> bet * 30;
                case "⭐" -> bet * 50;
                default -> 0;
            };
        } else if (row[0].equals(row[1])) {
            return switch (row[0]) {
                case "🍒" -> bet * 3;
                case "🍉" -> bet * 4;
                case "🍋" -> bet * 5;
                case "🔔" -> bet * 10;
                case "⭐" -> bet * 20;
                default -> 0;
            };
        } else if (row[1].equals(row[2])) {
            return switch (row[1]) {
                case "🍒" -> bet * 2;
                case "🍉" -> bet * 3;
                case "🍋" -> bet * 4;
                case "🔔" -> bet * 5;
                case "⭐" -> bet * 10;
                default -> 0;
            };
        }
        return 0;
    }


    private static String[] spinRow() {

        String[] symbols = {"🍒", "🍉", "🍋", "🔔", "⭐"};
        String[] row = new String[3];
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            row[i] = symbols[random.nextInt(symbols.length)];
        }

        return row;
    }

    private static void printFormattedMessage(boolean twoLine, boolean shortPadding, String... message) {
        if (twoLine && !shortPadding) {
            System.out.printf("""
                    
                    ##################################################
                    #####     %-31s    #####
                    #####     %-30s    #####
                    ##################################################
                    
                    """, message[0], message[1]);
        } else if (twoLine) {
            System.out.printf("""
                    
                    ###################################
                    #####     %-15s     #####
                    #####     %-15s    #####
                    ###################################
                    
                    """, message[0], message[1]);
        } else {
            System.out.printf("""
                    
                    ---------------------------------------------------
                    -----     %-30s     ------
                    ---------------------------------------------------
                    
                    """, message[0]);
        }
    }


}
