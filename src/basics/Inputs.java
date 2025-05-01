package basics;

import java.util.Scanner;

public class Inputs {
    public static void main(String[] args) {

        // Calculate the area of a rectangle
        double width = 0;
        double height = 0;
        double area = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the width of the rectangle: ");
        width = scanner.nextDouble();
        System.out.print("Enter the height of the rectangle: ");
        height = scanner.nextDouble();

        // Calculate the area
        area = width * height;
        System.out.println("The area of the rectangle is: " + area + "cm²");


        scanner.close();
    }
}
