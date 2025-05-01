package oop.inheritance;

public class Dog extends Animal {

    String name;

    Dog(String name, String type) {
        // Super keyword is used to call the parent class
        super(type);
        this.name = name;
    }

    void bark() {
        System.out.println(name + " says **Woof**");
    }

    @Override
    public String toString() {
        return "Dog{" + "name='" + name + '\'' + ", type='" + type + '\'' + ", isAlive=" + isAlive + '}';
    }
}
