package basics;

import java.util.Scanner;

public class JArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] groceries;
        int size;

        int arraySize = 0;
        System.out.print("Enter # of Groceries you want to bring: ");
        size = scanner.nextInt();
        scanner.nextLine();

        groceries = new String[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter Item: ");
            groceries[i] = scanner.nextLine();
        }

        System.out.print("""
                
                ------------------------------------
                -------->> Groceries List <<--------
                ------------------------------------
                """);
        for (int i = 0; i < groceries.length; i++) {
            System.out.printf("[%02d] %s \n", i + 1, groceries[i]);
        }
        System.out.println("------------------------------------");
        scanner.close();
    }
}
