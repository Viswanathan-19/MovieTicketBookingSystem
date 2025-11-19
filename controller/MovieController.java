package controller;

import java.time.LocalDate;
import java.util.*;

import model.*;
import view.Main;

public class MovieController {
    
    public boolean displayMoviesByDate(LocalDate date){
        Set<Integer> movieIds=new HashSet<>();
        for(Show s:Main.shows.values()){
            if(s.getShowDate().equals(date)){
                movieIds.add(s.getMovieId());
            }

        }
                
        if (movieIds.isEmpty()) {
                System.out.println("No movies available on " + date);
                System.out.println("Bookings are available from "+LocalDate.now()+" To "+LocalDate.now().plusDays(1));
                return false;
            }

        System.out.println("\nMovies available on " + date + ":");
        for(int movieId:movieIds){
            Movie movie=Main.movies.get(movieId);
             System.out.println("- " + movie.getmovieName());
        }
        return true;
    }
}
