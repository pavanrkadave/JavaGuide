package oop.interfaces;

public class Main {
    public static void main(String[] args) {
        // Create Rabbit
        Rabbit rabbit = new Rabbit();
        rabbit.flee();

        Hawk hawk = new Hawk();
        hawk.hunt();

        Fish fish = new Fish();
        fish.flee();
        fish.hunt();
    }
}
