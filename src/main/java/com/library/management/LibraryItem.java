
package com.library.management;


public abstract class LibraryItem {
    private final String id;
    private final String title;
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
    public abstract double calculateFine(int diasAtraso);
    
           
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
