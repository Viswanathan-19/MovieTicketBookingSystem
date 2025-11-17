package controller;

import java.time.LocalDate;
import java.time.LocalTime;

import view.Main;
import model.*;



public class ScreenController {
     
    public int getScreenId(LocalTime time,int movieId,int theatreId,LocalDate showDate){
        for(Show s:Main.shows.values()){
            if(s.getMovieId() == movieId 
            && s.getTheatreId() == theatreId
            && s.getShowDate().equals(showDate)
            &&s.getShowTime().equals(time)){
             return s.getScreenId();
            }
        }
        return 0;

       
    }

    public void displaySeatsByShowTime(LocalTime showTime,int movieId,int theatreId,LocalDate showDate){
              int screenId=getScreenId(showTime, movieId, theatreId, showDate);
            for(Screen s:Main.screens.values()){
                if(s.getScreenId() == screenId){
                    Screen sc=Main.screens.get(screenId);
                    sc.availableSeats();
                }
            }
           
          
    }
    
}
