package basics;

import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
        // Varargs = allow methods to accept varying number of arguments.
        // makes methods more flexible, no need for overloaded methods
        // Java will pack the arguments into an array.
        System.out.println(average(1));
        System.out.println(average(1, 2, 3));
        System.out.println(average(1, 2, 3, 4));
        System.out.println(average());
    }

    static double average(double... numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        return Arrays.stream(numbers).sum() / numbers.length;
    }
}
