package oop.inheritance;

public class Animal extends Organism {
    String type;

    Animal(String type) {
        this.type = type;
    }

    void type() {
        System.out.println("I am of type " + type);
    }
}
