package controller;

import view.Main;

import java.time.*;
import java.util.*;

import model.*;

public class TheatreController {
    int movieId;
    int theatreId;
    LocalDate showDate;
 
    public Integer getMovieId(String movieName){
        Integer num=0;
        for(Movie movie:Main.movies.values()){
            if(movie.getmovieName().equalsIgnoreCase(movieName)){
                num=movie.getMovieId();
                break;
        }
    }
    return num;
}

   public int getTheatreId(String theatreName){
    for(Theatre t:Main.theatres.values()){
        if(t.getTheatreName().equalsIgnoreCase(theatreName)){
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
          System.out.print(t.getTheatreName()+" | ");
       }

}
    //to display shows in the theatres
    public void displayTheatresShows(String theatreName){
        theatreId=getTheatreId(theatreName);
       for(Show s:Main.shows.values()){
        if(theatreId == s.getTheatreId() && s.getShowDate().equals(showDate) && s.getMovieId() == movieId){
            Theatre t=Main.theatres.get(s.getTheatreId());
            System.out.println("TheatreName: "+t.getTheatreName()+" ScreenNo: "+s.getScreenId()+" ShowTime: "+s.getShowTime()+" ShowDate: "+s.getShowDate() );
        }
       }
    }
       public int returnMovieId(){
        return movieId;
       }
      
       public void displayTheatresAlternateShows(Show show){    //display the alternate shows ,if one of the shows is full
        
        for(Show s:Main.shows.values()){
            if(s.getMovieId() == show.getMovieId() 
            && s.getTheatreId() == show.getTheatreId()
            && s.getShowTime()!=show.getShowTime()
            &&s.getShowDate() == s.getShowDate()){
                Theatre t=Main.theatres.get(s.getTheatreId());
                 System.out.println("TheatreName: "+t.getTheatreName()+" ScreenNo: "+s.getScreenId()+" ShowTime: "+s.getShowTime()+" ShowDate: "+s.getShowDate() );
                 
                 
            }
            
        }
        return;
       }
    
       
       
        
}

