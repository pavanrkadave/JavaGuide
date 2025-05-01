package oop.basics;

public class Car {

    // Static Variables - Shared across all Cars - Is not thread safe.
    static final double MAX_SPEED = 300.0;
    static int totalCars = 0;

    // Static Block of code that is run when initialing
    static {
        System.out.println("Car Class Loaded");
    }

    // Instance Variables - With Default Access Modifier, ideally should be made private
    // along with getters and setters
    String make;
    String model;
    int year;
    boolean isRunning;

    public Car(String make, String model, int year) {
        System.out.println("Building Car");
        this.make = make;
        this.model = model;
        this.year = year;
        this.isRunning = false;
        totalCars++;
    }

    static int getTotalCars() {
        return totalCars;
    }

    // Static Helper Method that can be used without creating a car object
    static double convertKMToMiles(double km) {
        return km * 0.621371;
    }

    void startEngine() {
        isRunning = true;
        System.out.printf("[ %s-%s ] Engine Started...%n", make, model);
    }

    void stopEngine() {
        isRunning = false;
        System.out.printf("[ %s-%s ] Engine Stopped...%n", make, model);
    }

    void unlock() {
        System.out.printf("[ %s-%s ] Unlocked...%n", make, model);
    }

    void lock() {
        System.out.printf("[ %s-%s ] Locked...%n", make, model);
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", isRunning=" + isRunning +
                '}';
    }
}
