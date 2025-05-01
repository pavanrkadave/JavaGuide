package oop.wrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> groceries = new ArrayList<>();

        System.out.print("Enter the # of food items: ");
        int numItems = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 1; i <= numItems; i++) {
            System.out.print("Enter item #" + i + ": ");
            String item = scanner.nextLine();
            groceries.add(item);
        }
        Collections.sort(groceries);

        System.out.print("""
                
                --------------------------------
                ---   Grocery List   ---
                --------------------------------
                
                """);
        for (int i = 0; i < groceries.size(); i++) {
            System.out.printf("[%02d] %s%n", i + 1, groceries.get(i));
        }

        scanner.close();
    }
}
