package com.library.management;

import java.util.List;

public class LibraryService {

    private final List<LibraryItem> catalog;

    public LibraryService(List<LibraryItem> catalog) {
        this.catalog = catalog;
    }

    // Find an item by ID
    public LibraryItem findById(String id) {
        if (id == null) {
            return null;
        }

        for (LibraryItem item : catalog) {
            if (item.getId().equalsIgnoreCase(id.trim())) {
                return item;
            }
        }

        return null;
    }

    // show available books or DVDs
    public void showAvailableItems() {
        System.out.println("\n--- AVAILABLE ITEMS ---");

        boolean found = false;

        for (LibraryItem item : catalog) {
            if (!item.isBorrowed()) {

                String type;

                if (item instanceof Book) {
                type = "Book";
                } else {
                type = "DVD";
                }

                System.out.println(
                    type + " | " +
                    item.getId() + " | " +
                    item.getTitulo()
                );

                found = true;
            }
        }

        if (!found) {
            System.out.println("No items available.");
        }
    }

    // borrow a book or DVD
    public void borrowItem(String id) {
        LibraryItem item = findById(id);

        if (item == null) {
            System.out.println("Item not found.");
            return;
        }

        if (item.isBorrowed()) {
            System.out.println("This item is already borrowed.");
            return;
        }

        item.toBorrow();

        System.out.println(
            item.getTitulo() + " borrowed successfully!"
        );
    }

    // return a book or DVD
    public void returnItem(String id, int daysLate) {
        LibraryItem item = findById(id);

        if (item == null) {
            System.out.println("Item not found.");
            return;
        }

        if (!item.isBorrowed()) {
            System.out.println("This item is not borrowed.");
            return;
        }

        if (daysLate < 0) {
            System.out.println("Days late cannot be negative.");
            return;
        }

        double fine = item.calculateFine(daysLate);

        item.toReturn();

        System.out.println(
            item.getTitulo() + " returned successfully!"
        );

        if (fine > 0) {
            System.out.printf("Late fee: R$ %.2f%n", fine);
        }
    }
}