package basics;

import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) {
        Random random = new Random();

        int number1;
        int number2;
        number1 = random.nextInt(1, 6);
        number2 = random.nextInt(1, 6);
        System.out.println("You rolled a " + number1 + " and a " + number2 + ".");

        double randomDouble = random.nextDouble(1, 10);
        System.out.println("Random double between 1 and 10: " + randomDouble);

        boolean isHeads = random.nextBoolean();
        if (isHeads) {
            System.out.println("It's heads!");
        } else {
            System.out.println("It's tails!");
        }
    }
}
