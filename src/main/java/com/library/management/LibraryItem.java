
package com.library.management;


public abstract class LibraryItem {
    private String id;
    private String title;
    private boolean borrowed;
    
    public LibraryItem(String id, String title){
    
        this.id=id;
        this.title=title;
        this.borrowed=false;
    }
       
    public void toBorrow(){
        this.borrowed=true;
    }
    //Method for control which item will return to the library
    public void toReturn(){
        this.borrowed=false;
    }
    public String getTitulo(){
        return title;
    }
    public double calculateFine(int diasAtraso){
        return diasAtraso * 2.00;
    }
    
            
    public void setTitle(String title) {
        this.title = title;
    }
    public boolean isBorrowed(){
        return this.borrowed;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    
   
    
            
}
