package basics;

/*
 * This is a simple Java program that prints "Hello, World!" to the console.
 */
public class Variables {

    // This is the main function
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // Primitive basics.Variables are values stored directly in the memory (stack).
        // Reference basics.Variables are references (memory address) to objects that point to the heap.
        // Primitive Vs Reference
        // ---------    ---------
        // int          string
        // double       array
        // char         object
        // boolean

        int age = 28;
        System.out.println("Age: " + age);

        double price = 19.99;
        System.out.println("Price: " + price);

        char grade = 'A';
        System.out.println("Grade: " + grade);

        String name = "Pavan Hegde";
        System.out.println("Name: " + name);

        System.out.println("Hello, " + name + "! You are " + age + " years old.");
        System.out.printf("The price is $%.2f and your grade is %c", price, grade);
    }
}
