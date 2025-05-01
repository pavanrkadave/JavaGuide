package oop.inheritance;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Bruno", "Mammal");
        dog.bark();
        dog.type();
        System.out.println("Dog Name: " + dog.name);
        System.out.println(dog);
    }
}
