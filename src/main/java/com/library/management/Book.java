
package com.library.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Book extends LibraryItem{
    String author;
    public Book(String id, String title, String author){
        super(id,title);
        this.author=author;
    }

    public String getAuthor() {
        return author;
    }
    
    @Override
    public double calculateFine(int dias){
        return dias * 2.00;
    }
    
    
    //Method to borrow a book
    public static void Loan (List<LibraryItem> catalog, String idBuscado){
        for(LibraryItem item : catalog){
            if(item.getId().equalsIgnoreCase(idBuscado)){
                if(!item.isBorrowed()){
                    item.toBorrow();
                    System.out.println("\nSucess! The item " + item.getTitulo()+", was borrowed");
                }else{
                    System.out.println("\nOps! The item " + item.getTitulo()+", was already borrowed. Try again later");
                }
                return;
            }else{
                System.out.println("\nError: no item found");
            }
        }
    }
    
    //method to find which books is available
    public static void AvailableBooks(List<LibraryItem> catalog){
        System.out.println("\n--- AVAILABLE BOOKS FOR LOAN---\n");
         System.out.println("Quantidade de itens no catálogo: " + catalog.size());
        boolean foundBook = false;
        for( LibraryItem item: catalog){
            if(item instanceof Book && !item.isBorrowed()){
                Book book = (Book) item;
                System.out.println("\nID: " + book.getId() + " | Title: " + book.getTitulo() + " | Author: " + book.getAuthor());
                foundBook = true;
            }
        }
        if(!foundBook){
            System.out.println("No books available right now");
        }
        System.out.println("------------------------------------------");
        
    }
   
    //method to return a book without delay
    
    public static void returnBookRightTime (List<LibraryItem> catalog, String idBuscado){
        for(LibraryItem item : catalog){
            if(item.getId().equalsIgnoreCase(idBuscado)){
                if(item.isBorrowed()){
                    item.toReturn();
                    System.out.println("\nSucess,the book was sucessfully returned. ");
                }
        }
    }
   }
    //method to return a book WITH DELAY
    
    public static void returnBookFine(List<LibraryItem> catalog, String idBuscado, int day){
        for(LibraryItem item : catalog){
            if(item.getId().equalsIgnoreCase(idBuscado)){
                if(item.isBorrowed()){
                    System.out.println("\nYou owe " +item.calculateFine(day) + " $");
                    System.out.println("\nBook returned with sucess! \n");
       
                }
             }
         }
    }
    public static void Questions(List<LibraryItem> catalog){
              
            Scanner scan = new Scanner (System.in);
            System.out.println("\n4 - To borrow the book");
            System.out.println("\n5 - To return the book");
            System.out.println("\n6 - Back");
            int R2 = scan.nextInt();
            scan.nextLine();
            switch(R2){
                   
                    case 4: 
                            Book.AvailableBooks(catalog);
                            System.out.println("\nType the book ID for borrow:\n");
                            String id = scan.nextLine();
                            Book.Loan(catalog, id);
                            System.out.println("Sucess!The book has been successfully borrowed. "
                                    + "The late free is $2 per day. Would you like to continue with the program? y or n \n");
                            String message1 = scan.nextLine();
                            switch(message1){
                                case "y": Book.Questions(catalog);
                                break;
                                case "n": System.exit(0);
                                break;
                                default: System.out.println("Please,try again\n");
                            }
                    break;
                    case 5: 
                        System.out.println("Is payday late? y or n");
                        String res = scan.nextLine();
                        switch(res){
                            case "y":
                                System.out.println("\nType the days:");
                                int day = scan.nextInt();
                                 scan.nextLine();
                                System.out.println("\nType the book ID for return:");
                                String id2 = scan.nextLine();
                                Book.returnBookFine(catalog, id2, day);
                                System.out.println("\n Would you like to continue with the program? y or n ");
                                String message2 = scan.nextLine();
                                switch(message2){
                                case "y": Book.Questions(catalog);break;
                                case "n": System.exit(0); break;
                                default: System.out.println("Please,try again\n");
                            }
                                
                           
                            case "n":
                                System.out.println("\nType the book ID for return:");
                                String id3= scan.nextLine();
                                Book.returnBookRightTime(catalog, id3);
                                System.out.println("\nSucess!The book has been successfully returned. "
                                    + " Would you like to continue with the program? y or n \n");
                            String message3 = scan.nextLine();
                            
                            switch(message3){
                                case "y": Book.Questions(catalog);
                                break;
                                case "n": System.exit(0);
                                break;
                                default: System.out.println("Please,try again\n");
                            }
                           
                            break;
                               
                        }
                        break;
                    case 6: System.out.println("\nGoodBye!");
                           LibraryManagement library = new LibraryManagement();
                           MainQuestions main = new MainQuestions();
                           main.QuestionMenu();
                           int R1 = scan.nextInt();
                           scan.nextLine();
                            switch (R1) {
                            case 1:
                             Book.Questions(catalog);
                            break;
                            case 2:
                             break;
                            default:
                                System.exit(0);
                            }
                           break;

                   default: System.out.println("\nTry again");
                    }
            
            scan.close();
        
    }
    
    
    
}
