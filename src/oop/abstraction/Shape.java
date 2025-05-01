package oop.abstraction;

public abstract class Shape {

    abstract double area(); // Abstract method to calculate area

    void display() { // Concrete method to display the shape type
        System.out.println("This is a shape.");
    }
}
