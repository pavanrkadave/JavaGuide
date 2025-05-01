package oop.basics;

public class Main {
    public static void main(String[] args) {

        System.out.println(Car.MAX_SPEED);

        Car car1 = new Car("BMW", "M3 Competition", 2025);
        Car car2 = new Car("BMW", "X5M", 2025);
        Car car3 = new Car("Audi", "RSQ8", 2025);

        Car[] cars = {car1, car2, car3};

        for (Car car : cars) {
            car.unlock();
            car.startEngine();
        }


        System.out.println("Total Cars : " + Car.getTotalCars());
        double speedToConvert = 162.0;
        System.out.printf("%.2fKmph ==> %.2f Mph", speedToConvert, Car.convertKMToMiles(100));
    }
}
