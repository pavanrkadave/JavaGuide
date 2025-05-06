package oop.anonymous;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();

        Dog scooby = new Dog() {
            @Override
            void speak() {
                System.out.println("Scooby Doo Says **Ruh Roh**");
            }
        };

        dog.speak();
        scooby.speak();
    }
}
