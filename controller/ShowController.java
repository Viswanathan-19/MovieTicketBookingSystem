package controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import view.Main;
import model.*;



public class ShowController {
    Show show;
    private static final AtomicInteger bookingIdGenerator = new AtomicInteger(0);
     Scanner sc=new Scanner(System.in);

    public LocalTime getShowTime(){
        LocalTime showTime;
         while(true){
               try{
              System.out.print("Enter show time (HH:mm): ");
                    String timeInput = sc.nextLine();

                    showTime=LocalTime.parse(timeInput);
                    break;
                }
                catch(Exception e){
                    System.out.println("Invalid time format! Please enter again in HH:mm format.");
                }
    }
    return showTime;
}
     
    public int getShowId(LocalTime time,int movieId,int theatreId,LocalDate showDate){
        for(Show s:Main.shows.values()){
            if(s.getMovieId() == movieId 
            && s.getTheatreId() == theatreId
            && s.getShowDate().equals(showDate)
            &&s.getShowTime().equals(time)){
             return s.getShowId();
            }
        }
        return 0;

       
    }

    public  Show displaySeatsByShowTime(LocalTime showTime,int movieId,int theatreId,LocalDate showDate){
              
                      
              int showId=getShowId(showTime, movieId, theatreId, showDate);  //get showId
              show=Main.shows.get(showId);
            //   System.out.println("showid "+showId+" "+show.getShowId()+" "+show.getTheatreId());
              Show currentShow = show;
                synchronized(currentShow){
                 
                    System.out.println(Thread.currentThread().getName() + " Available Seats are:");
                    show.displayAllSeats();
            
                    return currentShow;
                        }
        }
           
          
    

    

   public void bookSeats(String[] seatNumbers, Show show,int userId) {
   
   synchronized(show){
    List<String> locked = new ArrayList<>();

    // lock each seat
    for (String seat : seatNumbers) {
        if (show.lockSeats(seat)) {
            locked.add(seat);
            System.out.println(Thread.currentThread().getName()+" "+seat + " locked!");
        } else {
            System.out.println(Thread.currentThread().getName()+" "+seat + " cannot be locked! or already booked! Try again");
            return ;
        }
    }

    if (locked.isEmpty()) return ;

     boolean flag= confirm(locked, show);
     if(!flag)return;
      

    // Finalize booking
    for (String seat : locked) {
       
        if(show.isLockExpired(seat)){
            System.out.println(Thread.currentThread().getName()+" Time expired try again");
            for (String seat1: locked) {
            show.unlockSeat(seat1);
        }
             return ;
            }
        if (show.finalizeBooking(seat) ) {
            // show.isAvailableSeats(seat);
            System.out.println(seat + " BOOKED!");
        } else {
            System.out.println(seat + " lock expired!");
        }
      
    }
           System.out.println("Seats after booking: ");
           show.displayAllSeats();
     
            Booking b=new Booking(bookingIdGenerator.incrementAndGet(), show,userId,locked); //store booking information only once
            Booking.bookings.put(b.getBookingId(),b);
            return; 
}
}

   // confirm with the user
  public boolean confirm(List<String> locked,Show show){
    Scanner sc = new Scanner(System.in);
    System.out.print("\nConfirm booking? yes/no: ");
    String answer = sc.nextLine();

    if (!answer.equalsIgnoreCase("yes")) {
        System.out.println("Booking cancelled.");
        for (String seat : locked) {
            show.unlockSeat(seat);
        }
        return false;
    }
    return true;
    
}

    
}

