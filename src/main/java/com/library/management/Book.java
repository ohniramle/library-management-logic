
package com.library.management;

public class Book extends LibraryItem {

    private final String author;

    public Book(String id, String title, String author) {
        super(id, title);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public double calculateFine(int daysLate) {
        return Math.max(0, daysLate) * 2.00;
    }
}
