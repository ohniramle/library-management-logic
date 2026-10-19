
package com.library.management;


public class DVD extends LibraryItem {
    private final double duration;
    
    public DVD(String id, String title, final double duration){
        super(id,title);
        this.duration=duration;
    }

    public double getDuration() {
        return duration;
    }
    
    
    @Override
    public double calculateFine(int daysLate){
        return Math.max(0,daysLate) * 5;
    }
}
