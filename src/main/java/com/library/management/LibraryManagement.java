

package com.library.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LibraryManagement {

    public static void main(String[] args) {
       
        Scanner scan = new Scanner(System.in);
         List<LibraryItem> catalog = new ArrayList<>();
         
        Book book = new Book("B01","Lord of the Rings","Tolkien");
        catalog.add(book);
        Book book2 = new Book("B02","Harry Potter and the philosopher´s stone","J.K Rowling");
        catalog.add(book2);
        Book book3 = new Book("B03","The Fault in Iour Stars","John Green");
        catalog.add(book3);
        DVD dvd1 = new DVD("D01","Star Wars: Episode III",2.20);
        catalog.add(dvd1);
        DVD dvd2 = new DVD("D02","The GodFather",2.55);
        catalog.add(dvd2);
        DVD dvd3 = new DVD("DO3","Mean Girls",1.37);
        catalog.add(dvd3);
       
        MainQuestions question = new MainQuestions();
        question.QuestionMenu();
        int R1 = scan.nextInt();
        scan.nextLine();
        
        if(R1==1){
            Book.Questions(catalog);
                                             
        }if(R1==2){
            
        }
        else{
            System.exit(0);
            
        }
      }
    }
                        
        
        
    

