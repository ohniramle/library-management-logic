
package com.library.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagement {

    public static void main(String[] args) {

        List<LibraryItem> catalog = new ArrayList<>();

        // books
        catalog.add(new Book("B01", "Lord of the Rings", "Tolkien"));
        catalog.add(new Book("B02", "Harry Potter", "J.K. Rowling"));
        catalog.add(new Book("B03", "The Fault in Our Stars", "John Green"));

        // DVDs
        catalog.add(new DVD("D01", "Star Wars: Episode III", 2.20));
        catalog.add(new DVD("D02", "The Godfather", 2.55));
        catalog.add(new DVD("D03", "Mean Girls", 1.37));

        LibraryService service = new LibraryService(catalog);

        try (Scanner scan = new Scanner(System.in)) {

            boolean running = true;

            while (running) {

                System.out.println("\n=== LIBRARY MANAGEMENT ===");
                System.out.println("1 - Show available items");
                System.out.println("2 - Borrow an item");
                System.out.println("3 - Return an item");
                System.out.println("0 - Exit");
                System.out.print("Choose an option: ");

                String option = scan.nextLine().trim();

                switch (option) {

                    case "1":
                        service.showAvailableItems();
                        break;

                    case "2":
                        service.showAvailableItems();

                        System.out.print("\nEnter item ID: ");
                        String borrowId = scan.nextLine();

                        service.borrowItem(borrowId);
                        break;

                    case "3":
                        System.out.print("\nEnter item ID: ");
                        String returnId = scan.nextLine();

                        System.out.print("Days late (0 if on time): ");

                        try {
                            int daysLate = Integer.parseInt(
                                scan.nextLine().trim()
                            );

                            service.returnItem(returnId, daysLate);

                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number of days.");
                        }

                        break;

                    case "0":
                        running = false;
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        }
    }
}
