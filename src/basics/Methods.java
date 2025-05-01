package basics;

import java.util.Scanner;

public class Methods {

    static int age;

    public static void main(String[] args) {

        birthdayGreeting("Pavan", 28, 2025);
        birthdayGreeting("Namita", 27, 2025);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        age = scanner.nextInt();

        if (ageCheck(age)) {
            System.out.println("You can sign up!");
        } else {
            System.out.println("You must be 18 years old to do this.");
        }

        System.out.println("Age In Main: " + age);
        age = changeAge(++age);
        System.out.println("Age In Main After ChangeAge: " + age);

        var c = add(1, 2);
        System.out.println(c);

        var c2 = add(2, 3, 4);
        System.out.println(c2);
    }

    private static int changeAge(int age) {
        System.out.println("Age In ChangeAge: " + age);
        return ++age;
    }

    private static void birthdayGreeting(String name, int age, int year) {

        // Pad the name with spaces to make it 20 characters long, age to make it 2 characters long and year to make it 4 characters long
        String paddedAge = String.format("%02d", age);
        String paddedYear = String.format("%04d", year);
        String paddedName = String.format("%-20s", name);

        // Print the birthday greeting with printf
        System.out.printf("""
                
                ---------------->> HAPPY BIRTHDAY <<------------------
                ---- Hey! %s                    ----
                ---- You are %s years old!                        ----
                ---- May %s bring all the joy and happiness!    ----
                ---- Happy Birthday again                         ----
                ------------------------------------------------------
                
                """, paddedName, paddedAge, paddedYear);
    }

    private static boolean ageCheck(int age) {
        return age > 18;
    }

    // Method Overloading
    static double add(double a, double b) {
        return a + b;
    }

    static double add(double a, double b, double c) {
        return a + b + c;
    }
}
