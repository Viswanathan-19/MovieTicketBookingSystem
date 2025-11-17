package model;

import java.util.*;

public class Screen {
    private int screenId;
    private int theatreId;
    private int totalSeats;

    private List<String> allseats=new ArrayList<>();
    private Set<String> bookedseats=new HashSet<>();


    public Screen(int screenId, int theatreId, int totalSeats) {
        this.screenId = screenId;
        this.theatreId = theatreId;
        this.totalSeats = totalSeats;

        generateSeats();
    }



     private void generateSeats() {
     char row = 'A';
    for (int r = 0; r < 3; r++) {        
        for (int c = 1; c <= 10; c++) {  
            allseats.add("" + row + c);
        }
        row++;
    }
 }  

  public void availableSeats(){
    int c=1;
      for(String s:allseats){
        System.out.print(s+" ");
        if(c%10 == 0){
            System.out.println();
        }
        c++;
      }
  }

   

    public int getScreenId() {   return screenId; }

    public void setScreenId(int screenId) {   this.screenId = screenId;}

    public int getTheatreId() {   return theatreId; }

    public void setTheatreId(int theatreId) {  this.theatreId = theatreId;}

    public int getTotalSeats() { return totalSeats;  }

    public void setTotalSeats(int totalSeats) {this.totalSeats = totalSeats; }
   


    
}
    
    

