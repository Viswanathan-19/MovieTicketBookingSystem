package model;

import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class Show {

    private int showId;
    private int movieId;
    private int theatreId;
    private int screenId;
    private LocalDate showDate;
    private LocalTime showTime;
    private double ticketPrice;

    private List<String> allSeats = new ArrayList<>();
    private Set<String> bookedSeats = new HashSet<>();

    private ConcurrentHashMap<String,Long> lockedSeats=new ConcurrentHashMap<>();
    private final long LOCK_DURATION_MS=5000;

    public Show(int showId, int movieId, int theatreId, int screenId, LocalDate showDate, LocalTime showTime,
            double ticketPrice) {
        this.showId = showId;
        this.movieId = movieId;
        this.theatreId = theatreId;
        this.screenId = screenId;
        this.showDate = showDate;
        this.showTime = showTime;
        this.ticketPrice = ticketPrice;
         generateSeats();
    }

    private void generateSeats() {
        char row = 'A';
        for (int r = 0; r < 3; r++) {
            for (int c = 1; c <= 10; c++) {
                allSeats.add("" + row + c);
            }
            row++;
        }
    }

    public synchronized boolean lockSeats(String seat){
        long now=System.currentTimeMillis();

        if(bookedSeats.contains(seat)){  //to check already booked seats
            return false;
        }

        if(lockedSeats.containsKey(seat)){   //to check already locked seats
            return false;
        }
        lockedSeats.put(seat, now);  //lock the seat with time
        
        return true;

    }

    public boolean isLockExpired(String seat){
         Long lockTime=lockedSeats.get(seat);
         if(lockTime == null) return true;

         long now=System.currentTimeMillis();
         return (now - lockTime)>LOCK_DURATION_MS;
    }

    public synchronized void unlockSeat(String seat) {
      lockedSeats.remove(seat);
    }

    public synchronized boolean isAvailableSeats(String seat) {

    if (bookedSeats.contains(seat))
    { 
        // System.out.println(Thread.currentThread().getName()+"booked "+seat);
         return false;
        }

    if (lockedSeats.containsKey(seat)) {
        if (!isLockExpired(seat)) return false;
        else unlockSeat(seat);  
    }

    return true;
}


   

    public  void displayAllSeats() {
        
        int count = 1;
        for (String seat : allSeats) {
            if (bookedSeats.contains(seat))
                System.out.print("[*" + seat + "*] ");
            else
                System.out.print(seat + " ");

            if (count % 10 == 0) System.out.println();
            count++;
        }
        System.out.println();
    }
   
    

    public synchronized boolean finalizeBooking(String seat) {
    if (!lockedSeats.containsKey(seat)) return false;  //check already locked
    if (isLockExpired(seat)) {       //check isexpired
        unlockSeat(seat);
        return false;
    }

    bookedSeats.add(seat);
    lockedSeats.remove(seat);

    return true;
}



    public int getShowId() {   return showId;  }


    public void setShowId(int showId) { this.showId = showId; }


    public int getMovieId() { return movieId;}


    public void setMovieId(int movieId) {  this.movieId = movieId;  }


    public int getTheatreId() {    return theatreId;}


    public void setTheatreId(int theatreId) {this.theatreId = theatreId; }


    public int getScreenId() { return screenId;  }


    public void setScreenId(int screenId) {this.screenId = screenId;}


    public LocalDate getShowDate() {   return showDate; }


    public void setShowDate(LocalDate showDate) {this.showDate = showDate; }


    public LocalTime getShowTime() { return showTime;}


    public void setShowTime(LocalTime showTime) {  this.showTime = showTime;}


    public double getTicketPrice() {  return ticketPrice;  }


    public void setTicketPrice(double ticketPrice) {  this.ticketPrice = ticketPrice; }

    
    

    
}
