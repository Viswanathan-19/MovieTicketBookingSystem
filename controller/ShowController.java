package controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import view.Main;
import model.*;
import util.ScannerProvider;



public class ShowController {
    Show show;
    private static final AtomicInteger bookingIdGenerator = new AtomicInteger(0);
    

//     public LocalTime getShowTime(){
//         LocalTime showTime;
//          while(true){
//                try{
//               System.out.print("Enter show time (HH:mm): ");
//                     String timeInput = sc.nextLine();

//                     showTime=LocalTime.parse(timeInput);
//                     break;
//                 }
//                 catch(Exception e){
//                     System.out.println("Invalid time format! Please enter again in HH:mm format.");
//                 }
//     }
//     return showTime;
// }
     
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

    public  int displaySeatsByShowTime(LocalTime showTime,int movieId,int theatreId,LocalDate showDate,int userId){
              
                      
        //   System.out.println(Thread.currentThread().getName()+" enters");
             
                synchronized(this){              
                    Scanner sc=ScannerProvider.getScanner();
                     int showId=getShowId(showTime, movieId, theatreId, showDate);  //get showId
              show=Main.shows.get(showId);
            //   System.out.println("showid "+showId+" "+show.getShowId()+" "+show.getTheatreId());
              Show currentShow = show;
                 
                    System.out.println(Thread.currentThread().getName() + " Available Seats for "+Main.movies.get(movieId).getmovieName()+" :");
                    show.displayAllSeats();
                    
                    System.out.println("Enter seats (space or comma separated): ");
                String seatInput = sc.nextLine();
                
                String[] seatNumbers=seatInput.split("[, ]+");
                int status=bookSeats(seatNumbers,currentShow,userId);
                   
                while (status == 0) {
                         System.out.println("Please Select Different Seats -> \n");
                          status = displaySeatsByShowTime( showTime, movieId,theatreId,showDate,userId);
                    }
                    return status;
                        }
        }
           
          
    

    

   public int bookSeats(String[] seatNumbers, Show show,int userId) {
   
    List<String> locked = new ArrayList<>();

    // lock each seat
    for (String seat : seatNumbers) {
        if (show.lockSeats(seat)) {
            locked.add(seat);
            System.out.println(Thread.currentThread().getName()+" "+seat + " locked!");
        } else {
               for(String seat1:seatNumbers){   //if one of the seats is not locked ,unlock all the seats for rebooking
                   show.unlockSeat(seat1);
               }
            System.out.println(Thread.currentThread().getName()+" "+seat + " cannot be locked! or already booked! Try again\n");
            return 0 ;
        }
    }

    if (locked.isEmpty()) return 0;

     boolean flag= confirm(locked, show);
     if(!flag)return 1;
      

    // Finalize booking
    for (String seat : locked) {
       
        if(show.isLockExpired(seat)){
            System.out.println(Thread.currentThread().getName()+" Time expired try again");
            for (String seat1: locked) {
            show.unlockSeat(seat1);
        }
             return 1;
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
            Booking.bookings.putIfAbsent(b.getBookingId(),b);
           
            return 1; 
}


   // confirm with the user
  public boolean confirm(List<String> locked,Show show){
    Scanner sc = ScannerProvider.getScanner();
    System.out.print("\nConfirm booking? yes/no: ");
    String answer = sc.nextLine();

    if (!answer.equalsIgnoreCase("yes")) {
        System.out.println("Booking cancelled.");
        for (String seat : locked) {
            show.unlockSeat(seat);
        }
        // System.out.println("\n Available seats are: ");
        // show.displayAllSeats();
        return false;
    }
    return true;
    
}

    
}

