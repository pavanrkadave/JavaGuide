package basics;

public class StrFormat {
    public static void main(String[] args) {
        String name = "Pavan Hegde";
        char firstLetter = name.charAt(0);
        int age = 28;
        double height = 5.7;
        boolean isStudent = true;

        String formattedString = String.format("""
                ############################################################
                ##                                                        ##
                ##  Hello %s, your name starts with '%c'          ##
                ##  You are %d years old, and your height is %.1f feet.    ##
                ##  Is student: %b                                      ##
                ##                                                        ##
                ############################################################
                """, name, firstLetter, age, height, isStudent);

        System.out.println(formattedString);

        // printf() is a method used to format output in Java.
        // %[flags][width][.precision][specifier-character]

        double price1 = 99000.98;
        double price2 = 134924.15;
        double price3 = -5612.65;

        // The %f format specifier is used to format floating-point numbers.
        System.out.println("-------------------------------------");
        System.out.printf("Price 1 : $%f\n", price1);
        System.out.printf("Price 2 : $%f\n", price2);
        System.out.printf("Price 3 : $%f\n", price3);
        System.out.println("-------------------------------------");

        // The %.2f format specifier is used to format floating-point numbers with 2 decimal places.
        System.out.printf("Price 1 : $%.2f\n", price1);
        System.out.printf("Price 2 : $%.3f\n", price2);
        System.out.printf("Price 3 : $%.1f\n", price3);

        // + can be used to display the sign of the number.
        System.out.println("-------------------------------------");
        System.out.printf("Price 1 : $%+.2f\n", price1);
        System.out.printf("Price 2 : $%+.2f\n", price2);
        System.out.printf("Price 3 : $%+.2f\n", price3);

        // , can be used to display the number with commas.
        System.out.println("-------------------------------------");
        System.out.printf("Price 1 : $%,.2f\n", price1);
        System.out.printf("Price 2 : $%,.2f\n", price2);
        System.out.printf("Price 3 : $%,.2f\n", price3);

        // ( can be used to display the number in parentheses if it is negative.
        System.out.println("-------------------------------------");
        System.out.printf("Price 1 : $%(,.2f\n", price1);
        System.out.printf("Price 2 : $%(,.2f\n", price2);
        System.out.printf("Price 3 : $%(,.2f\n", price3);

        // space can be used to display a space before the number if it is positive.
        System.out.println("-------------------------------------");
        System.out.printf("Price 1 : $% .2f\n", price1);
        System.out.printf("Price 2 : $% .2f\n", price2);
        System.out.printf("Price 3 : $% .2f\n", price3);

        // [width]
        // 0 can be used to display the number with leading zeros.
        int id1 = 1;
        int id2 = 23;
        int id3 = 456;
        int id4 = 7890;

        System.out.println("-------------------------------------");
        System.out.printf("ID 1 : %04d\n", id1);
        System.out.printf("ID 2 : %04d\n", id2);
        System.out.printf("ID 3 : %04d\n", id3);
        System.out.printf("ID 4 : %04d\n", id4);

    }
}
