package oop.aggregation;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", 500);
        Book book2 = new Book("Data Structures", 300);
        Book book3 = new Book("Algorithms", 400);

        Book[] books = {book1, book2, book3};

        Library library = new Library("City Library", 2023, books);
        library.displayInfo();
    }
}
