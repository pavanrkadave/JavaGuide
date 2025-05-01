package oop.aggregation;

public class Book {
    String title;
    int pages;

    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    void displayInfo() {
        System.out.println("Title: " + title + ", Pages: " + pages);
    }
}
