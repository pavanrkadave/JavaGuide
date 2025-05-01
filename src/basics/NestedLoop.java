package basics;

import java.util.Scanner;

public class NestedLoop {
    public static void main(String[] args) {

        System.out.println("""
                --------------------------------
                --    Nested Loop Example     --
                --------------------------------
                """);
        int rows;
        int columns;
        char symbol;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the # of rows: ");
        rows = scanner.nextInt();

        System.out.print("Enter the # of columns: ");
        columns = scanner.nextInt();

        System.out.print("Enter the symbol to use: ");
        symbol = scanner.next().charAt(0);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("%c ", symbol);
            }
            System.out.println();
        }


        scanner.close();
    }
}
