package oop.interfaces;

public class Fish implements Prey, Predator {

    @Override
    public void hunt() {
        System.out.println("Fish is hunting!");
    }

    @Override
    public void flee() {
        System.out.println("Fish is swimming awayy!");
    }
}
