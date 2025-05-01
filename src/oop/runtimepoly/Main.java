package oop.runtimepoly;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Animal animal;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Would you like to hear a Dog or a Cat? (1 = Dog / 2 = Cat): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            animal = new Dog();
            animal.speak();
        } else if (choice == 2) {
            animal = new Cat();
            animal.speak();
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
