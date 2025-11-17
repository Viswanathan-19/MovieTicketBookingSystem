package controller;

import view.Main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import model.*;

public class TheatreController {
    Integer movieId;
    int theatreId;
    LocalDate showDate;
    
    Scanner sc=new Scanner(System.in);
    public Integer getMovieId(String movieName){
        Integer num=0;
        for(Movie movie:Main.movies.values()){
            if(movie.getmovieName().equals(movieName)){
                num=movie.getMovieId();
                break;
        }
    }
    return num;
}

   public int getTheatreId(String theatreName){
    for(Theatre t:Main.theatres.values()){
        if(t.getTheatreName().equals(theatreName)){
            return t.getTheatreId();
        }
    }
    return 0;
   }
   //To display the theatreNames
    public void displayTheatres(String movieName,LocalDate date){
          showDate =date;
           Set<Integer> theatreIds=new HashSet<>();
             movieId=getMovieId(movieName);
           
        for(Show s:Main.shows.values()){
            if(s.getMovieId() == movieId && s.getShowDate().equals(date)){
               theatreIds.add(s.getTheatreId());
        }
    }
      System.out.println("The Movie is available in the theatres");
       for(Integer id:theatreIds){
          Theatre t=Main.theatres.get(id);
          System.out.println(t.getTheatreName());
       }


}
    //to display shows in the theatres
    public void displayTheatresShows(String theatreName){
        theatreId=getTheatreId(theatreName);
       for(Show s:Main.shows.values()){
        if(theatreId == s.getTheatreId() && s.getShowDate().equals(showDate)){
            Theatre t=Main.theatres.get(s.getTheatreId());
            System.out.println("TheatreName: "+t.getTheatreName()+" ScreenNo: "+s.getScreenId()+" ShowTime: "+s.getShowTime()+" ShowDate: "+s.getShowDate() +" TicketPrice: "+s.getTicketPrice());
        }
       }
         LocalTime showTime=null;
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
               
        ScreenController screenController=new ScreenController();
        screenController.displaySeatsByShowTime(showTime, movieId, theatreId, showDate);
      
    }
       
       
        
}

