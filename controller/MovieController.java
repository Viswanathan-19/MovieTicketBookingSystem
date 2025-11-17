package controller;

import java.time.LocalDate;
import java.util.*;

import model.*;
import view.Main;

public class MovieController {
    
    public void displayMoviesByDate(LocalDate date){
        Set<Integer> movieIds=new HashSet<>();
        for(Show s:Main.shows.values()){
            if(s.getShowDate().equals(date)){
                movieIds.add(s.getMovieId());
            }

        }
                
        if (movieIds.isEmpty()) {
                System.out.println("No movies available on " + date);
                return;
            }

        System.out.println("\nMovies available on " + date + ":");
        for(int movieId:movieIds){
            Movie movie=Main.movies.get(movieId);
             System.out.println("- " + movie.getmovieName());
        }
    }
}
