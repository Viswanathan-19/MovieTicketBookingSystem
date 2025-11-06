package controller;

import java.util.Scanner;

import model.*;


public class MovieController {

    Scanner sc=new Scanner(System.in);
     
    public String displayMovies(){
        System.out.println("\nThe List Of Movies Streaming are ->");
        for(Movie m:StoreData.movies){
            System.out.println(m.getMovieName());
        }

        System.out.print("Please select a movie to watch -> ");

        String movieName=sc.nextLine();

        return movieName;


    }
}
