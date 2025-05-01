package basics;

import java.util.Scanner;

public class Shoppy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===========================");
        System.out.println("==   Welcome to SHOPPY!  ==");
        System.out.println("===========================");

        String item;
        double price;
        int quantity;
        char currency = '€';
        double total;


        System.out.print("What item would you like to buy?: ");
        item = scanner.nextLine();

        System.out.print("What is the price for each item?: ");
        price = scanner.nextDouble();

        System.out.print("How many would you like?: ");
        quantity = scanner.nextInt();

        // Calculate the total
        total = price * quantity;
        System.out.println("\n\n");
        System.out.println("=============================");
        System.out.println("==  Your Shopping Receipt!  ==");
        System.out.println("=============================");
        System.out.println("Item: " + item);
        System.out.println("Price: " + currency + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total: " + currency + total);
        System.out.println("=============================");
        System.out.println("Thank you for shopping with us!");
        System.out.println("Have a great day!");
        System.out.println("=============================");


    }
}
