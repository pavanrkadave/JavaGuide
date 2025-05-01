package basics;

import java.time.LocalDate;
import java.util.Scanner;

public class AgeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------------------");
        System.out.println("-- Welcome to the Age Checker! --");
        System.out.println("---------------------------------");

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();

        // Calculate age
        String age = calculateAge(dob);
        System.out.println("Hello " + name + "! You are " + age + " old.");

        scanner.close();
    }

    // Calculate age in months days and years
    public static String calculateAge(String dob) {
        LocalDate today = LocalDate.now();
        LocalDate birthDate = LocalDate.parse(dob);
        int years = today.getYear() - birthDate.getYear();
        int months = today.getMonthValue() - birthDate.getMonthValue();
        int days = today.getDayOfMonth() - birthDate.getDayOfMonth();

        if (days < 0) {
            months--;
            days += today.lengthOfMonth();
        }
        if (months < 0) {
            years--;
            months += 12;
        }

        return years + " years, " + months + " months, and " + days + " days";
    }
}
