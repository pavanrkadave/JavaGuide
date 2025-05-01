package oop.abstraction;

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle(3);
        Triangle triangle = new Triangle(4, 5);
        Rectangle rectangle = new Rectangle(6, 7);

        System.out.printf("Circle Area: %.2f%n", circle.area());
        System.out.printf("Triangle Area: %.2f%n", triangle.area());
        System.out.printf("Rectangle Area: %.2f%n", rectangle.area());
    }
}
