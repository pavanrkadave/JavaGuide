package basics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) {

        final String WORDS_FILE = "words.txt";
        String word = getGetRandomWord(WORDS_FILE);
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        int wrongGuesses = 0;


        printFormattedMessage(true, "Welcome to the Game", "HANGMAN!!");
        for (int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }

        while (wrongGuesses < 6) {
            System.out.print(getHangmanArt(wrongGuesses));
            System.out.println("-----------------------------------");
            System.out.print("Word: ");
            for (char c : wordState) {
                System.out.print(c + " ");
            }
            System.out.println("\n-----------------------------------");

            System.out.print("\nGuess a letter: ");
            char guess = scanner.next().toUpperCase().charAt(0);

            if (word.indexOf(guess) >= 0) {
                System.out.println("""
                        
                        ------------------
                        | Correct Guess! |
                        ------------------
                        
                        """);
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        wordState.set(i, guess);
                    }
                }

                if (!wordState.contains('_')) {
                    printFormattedMessage(false, "YOU WIN!", "Word : " + word.toUpperCase());
                    System.out.println(getHangmanArt(wrongGuesses));
                    break;
                }
            } else {
                wrongGuesses++;
                System.out.println("""
                        
                        ----------------
                        | Wrong Guess! |
                        ----------------
                        
                        """);
            }
        }

        if (wrongGuesses >= 6) {
            printFormattedMessage(false, "GAME OVER", "The Correct Word was: " + word);
            System.out.println(getHangmanArt(wrongGuesses));
        }

        scanner.close();
    }

    private static String getGetRandomWord(String filePath) {
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error : " + e.getMessage());
        }

        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    private static String getHangmanArt(int wrongGuesses) {
        return switch (wrongGuesses) {
            case 0 -> """
                    ---------
                    |       |
                    |       |
                    ---------
                    """;
            case 1 -> """
                    ---------
                    |   o   |
                    |       |
                    ---------
                    """;
            case 2 -> """
                    ---------
                    |   o   |
                    |   |   |
                    ---------
                    
                    """;
            case 3 -> """
                    ---------
                    |   o   |
                    |  /|   |
                    ---------
                    """;
            case 4 -> """
                    ---------
                    |   o   |
                    |  /|\\  |
                    ---------
                    """;
            case 5 -> """
                    ---------
                    |   o   |
                    |  /|\\  |
                    |  /    |
                    ---------
                    """;
            case 6 -> """
                    ---------
                    |   o   |
                    |  /|\\  |
                    |  / \\  |
                    ---------
                    """;
            default -> "";
        };
    }

    private static void printFormattedMessage(boolean shortPadding, String... message) {
        if (!shortPadding) {
            System.out.printf("""
                    
                    #################################################
                    #####     %-30s    #####
                    #####     %-30s    #####
                    #################################################
                    
                    """, message[0], message[1]);
        } else {
            System.out.printf("""
                    
                    #######################################
                    #####     %-20s    #####
                    #####     %-20s    #####
                    #######################################
                    
                    """, message[0], message[1]);
        }
    }
}
