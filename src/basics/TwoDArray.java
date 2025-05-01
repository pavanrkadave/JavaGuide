package basics;

public class TwoDArray {
    public static void main(String[] args) {
        String[] fruits = {"Apple", "Banana", "Orange", "Strawberry"};
        String[] vegetables = {"Potato", "Onion", "Carrot", "Broccoli"};
        String[] spices = {"Cinnamon", "Pepper", "Turmeric", "Cloves"};

        String[][] groceries = {fruits, vegetables, spices};

        for (String[] foods : groceries) {
            System.out.print("|");
            for (String food : foods) {
                System.out.printf(" %-10s |",food);
            }
            System.out.println();
        }
    }
}
