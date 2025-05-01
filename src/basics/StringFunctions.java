package basics;

import java.util.Scanner;

public class StringFunctions {
    public static void main(String[] args) {
        String name = "Pavan Hegde";
        System.out.printf("Lenght of the string: %d%n", name.length());
        System.out.printf("First character: %c%n", name.charAt(0));
        System.out.printf("Index of 'H': %d%n", name.indexOf('H'));

        String email;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your email address: ");
        email = scanner.nextLine();
        var username = email.substring(0, email.indexOf('@'));
        var domain = email.substring(email.indexOf('@') + 1);
        System.out.println("Username: " + username);
        System.out.println("Domain: " + domain);
        scanner.close();
    }
}
