package basics;

import java.util.Random;
import java.util.Scanner;

public class RollDice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int noOfDice;
        int totalRolled = 0;

        System.out.print("""
                
                -------------------------------------------
                -------->>      DICE ROLLER      <<--------
                -------------------------------------------
                
                """);
        System.out.print("Enter # of dice to roll: ");
        noOfDice = scanner.nextInt();

        if (noOfDice > 0) {
            for (int i = 0; i < noOfDice; i++) {
                int roll = random.nextInt(1, 7);
                printDie(roll);
                totalRolled += roll;
            }
            System.out.printf("""
                    
                    -------------------------------------------
                    TOTAL ROLLED : %d
                    -------------------------------------------
                    
                    """, totalRolled);
        } else {
            System.out.println("# of dice must be greater than 0");
        }
    }

    static void printDie(int roll) {
        String dice1 = """
                 -------
                |       |
                |   •   |
                |       |
                 -------
                """;

        String dice2 = """
                 -------
                | •     |
                |       |
                |     • |
                 -------
                """;

        String dice3 = """
                 -------
                | •     |
                |   •   |
                |     • |
                 -------
                """;

        String dice4 = """
                 -------
                | •   • |
                |       |
                | •   • |
                 -------
                """;

        String dice5 = """
                 -------
                | •   • |
                |   •   |
                | •   • |
                 -------
                """;

        String dice6 = """
                 -------
                | • • • |
                | • • • |
                | • • • |
                 -------
                """;

        switch (roll) {
            case 1 -> System.out.print(dice1);
            case 2 -> System.out.print(dice2);
            case 3 -> System.out.print(dice3);
            case 4 -> System.out.print(dice4);
            case 5 -> System.out.print(dice5);
            case 6 -> System.out.print(dice6);
            default -> System.out.println("INVALID ROLL");
        }
    }
}
