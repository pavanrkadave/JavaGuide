package basics;

import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double radius;
        double circumference;
        double area;
        double volume;

        System.out.println("----------------------------------");
        System.out.println("|      Circle Program            |");
        System.out.println("----------------------------------");
        System.out.print("Enter the radius of the circle: ");
        radius = scanner.nextDouble();



        circumference = 2 * Math.PI * radius;
        area = Math.PI * Math.pow(radius, 2);
        volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);

        System.out.println("-----------------------------------------");
        System.out.printf("| Circumference of the circle: %.2f cm |\n", circumference);
        System.out.printf("| Area of the circle: %.2f cm²         |\n", area);
        System.out.printf("| Volume of the sphere: %.2f cm³      |\n", volume);
        System.out.println("-----------------------------------------");

        scanner.close();
    }
}
