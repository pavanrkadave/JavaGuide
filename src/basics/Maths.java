package basics;

public class Maths {
    public static void main(String[] args) {
        System.out.println("---------------------");
        System.out.println("--  basics.Maths Program  --");
        System.out.println("---------------------");

        System.out.println("Value of PI: " + Math.PI);
        System.out.println("Value of E: " + Math.E);

        System.out.println("Square root of 16: " + Math.sqrt(16));
        System.out.println("2 to the power of 5: " + Math.pow(2, 5));
        System.out.println("Abs(-10): " + Math.abs(-10));
        System.out.println("Max of 10 and 20: " + Math.max(10, 20));
        System.out.println("Min of 10 and 20: " + Math.min(10, 20));
        System.out.println("Random number: " + Math.random());
        System.out.println("Random number between 0 and 100: " + (int)(Math.random() * 100));
        System.out.println("Floor of 10.5: " + Math.floor(10.5));
        System.out.println("Ceil of 10.5: " + Math.ceil(10.5));
    }
}
