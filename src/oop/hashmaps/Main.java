package oop.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, Double> fruits = new HashMap<>();
        fruits.put("Apple", 1.99);
        fruits.put("Banana", 0.99);
        fruits.put("Orange", 1.49);
        fruits.put("Grapes", 2.99);
        fruits.put("Mango", 1.79);
        fruits.put("Pineapple", 3.49);
        fruits.put("Strawberry", 2.49);
        fruits.put("Blueberry", 2.99);

        // Print the map
        System.out.println("Fruits and their prices:");
        for (Map.Entry<String, Double> entry : fruits.entrySet()) {
            System.out.println(entry.getKey() + " => $" + entry.getValue());
        }

        System.out.println(fruits.entrySet());
    }
}
