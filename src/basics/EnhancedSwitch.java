package basics;

import java.util.Scanner;

public class EnhancedSwitch {
    public static void main(String[] args) {
        String day;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a day of the week: ");
        day = scanner.nextLine().toLowerCase();

        switch (day) {
            case "monday" -> System.out.println("Start of the work week! \uD83D\uDE13");
            case "tuesday" -> System.out.println("It's Tuesday! \uD83D\uDE13");
            case "wednesday" -> System.out.println("Midweek already! \uD83D\uDE2E\u200D\uD83D\uDCA8");
            case "thursday" -> System.out.println("Almost Friday! \uD83E\uDD29");
            case "friday" -> System.out.println("TGIF! \uD83E\uDD29");
            case "saturday", "sunday" -> System.out.println("Rest and recharge! \uD83D\uDE0E");
            default -> System.out.println("Invalid day entered. \uD83D\uDC7D");
        }
        scanner.close();
    }
}
