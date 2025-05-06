package oop.generics;

public class Main {
    public static void main(String[] args) {
        Box<String> banana = new Box<>("Banana");

        Rack<String, Double> items = new Rack<>("Engine Oil", 10.0);

        System.out.println(banana.getContent());
        System.out.println(items.getItem() + " => " + items.getQuantity());
    }
}
