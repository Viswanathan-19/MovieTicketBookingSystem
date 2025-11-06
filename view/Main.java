package view;

import java.util.Scanner;

import controller.MovieController;
import controller.TheatreController;
import controller.UserController;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        UserController userController=new UserController();
        MovieController movieController=new MovieController();
        TheatreController theatreController=new TheatreController();

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
                 
                return;
            }
            else{
                System.out.println("Invalid username or password");
            }
            }
        }
    

    }

