package basics;

import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        // Questions Array[]
        String[] questions = {"What is the main function of a router?",
                "Which part of the computer is considered the brain?",
                "What year was facebook founded?",
                "Who is known as the father of computer?",
                "What was the first programming language?"};
        String[][] options = {{"Storing files", "Encrypting Data", "Directing internet traffic"},
                {"Motherboard", "RAM", "Hard Drive", "CPU"},
                {"2000", "2004", "2008", "2005"},
                {"Steve Jobs", "Alan Turing", "Charles Babbage", "Bill Gates"},
                {"Fortran", "COBOL", "C", "Assembly", "C++"}};
        int[] answers = {3, 4, 2, 3, 1};
        int score = 0;
        int guess;
        Scanner scanner = new Scanner(System.in);
        printWelcomeMessage();

        for (int i = 0; i < questions.length; i++) {
            System.out.printf("""
                    
                    -----------------------------------------------------------------
                    Question %d : %-55s
                    -----------------------------------------------------------------
                    """, i + 1, questions[i]);
            for (int j = 0; j < options[i].length; j++) {
                System.out.printf("%d. %s%n", j + 1, options[i][j]);
            }
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            if (guess == answers[i]) {
                System.out.println("""
                        -----------------------------------------------------------------
                        CORRECT ANSWER!
                        -----------------------------------------------------------------
                        """);
                score++;
            } else {
                System.out.println("""
                        -----------------------------------------------------------------
                        WRONG ANSWER!
                        -----------------------------------------------------------------
                        """
                );
            }
        }

        printScore(score);

        scanner.close();
    }

    private static void printScore(int score) {
        System.out.printf("""
                
                ##############################################
                ####    %-30s    ####
                ##############################################
                
                """, "Your Final Score is : " + score + "!!");
    }

    private static void printWelcomeMessage() {
        System.out.printf("""
                
                ###################################################
                ####      %s      ####
                ###################################################
                
                """, "Welcome to the Java basics.Quiz Game!!");
    }
}
