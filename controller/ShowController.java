package controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import model.*;

public class ShowController {
    Scanner sc=new Scanner(System.in);
    public List<Show> getShows(String movieName,String theatreName){
        Map<String,List<Show>> showMap=StoreData.shows.get(movieName);  
       if (showMap == null) return Collections.emptyList(); 
        return showMap.getOrDefault(theatreName, Collections.emptyList());

    }

    public LocalTime displayShows(String movieName,String theatreName) {
        List<Show> shows=getShows(movieName,theatreName);
        LocalTime time=LocalTime.now();
        if (shows.isEmpty()) {
            System.out.println("No shows available for " + movieName + " at " + theatreName);
        }
        else{

        System.out.println("Shows For "+movieName+" at "+theatreName+":");
        for(Show s:shows){
            System.out.println("- "+s.getShowTime()+" ("+s.getScreenNumber()+", Seats: "+s.getAvailableSeats()+")");
        }
        
        System.out.print("Please Select the Show Time -> ");
        String timeInput=sc.nextLine();
        
        try{
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm");
             time=LocalTime.parse(timeInput, formatter);
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
      return time;
    }
}
