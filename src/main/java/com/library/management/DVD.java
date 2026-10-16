
package com.library.management;


public class DVD extends LibraryItem {
    double duration;
    
    public DVD(String id, String title, double duration){
        super(id,title);
        this.duration=duration;
    }
    
    @Override
    public double calculateFine(int dias){
        return dias*5.00;
    }
}
