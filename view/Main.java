package view;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import controller.MovieController;
import controller.ShowController;
import controller.TheatreController;
import controller.UserController;
import model.StoreData;
import model.User;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        UserController userController=new UserController();
        MovieController movieController=new MovieController();
        TheatreController theatreController=new TheatreController();
        ShowController showController=new ShowController();

        System.out.println("Book Your Tickets Now");
            while(true){    
            System.out.println("Login -> ");

            System.out.print("Enter username: ");
            String userName=sc.nextLine();

            System.out.print("Enter password: ");
            String password=sc.nextLine(); 

            if(userController.authenticate(userName, password)){
                System.out.println("\nLogin successFul! Welcome "+userName);
                String movieName=movieController.displayMovies();
                 String theatreName= theatreController.displayTheatres(movieName);
                 LocalTime time=showController.displayShows(movieName,theatreName);
                 
                return;
            }
            else{
                System.out.println("Invalid username or password");
            }
            }
        }
    

    }

