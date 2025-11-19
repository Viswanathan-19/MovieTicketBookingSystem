package view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import controller.MovieController;
import controller.ShowController;
import controller.TheatreController;
import controller.UserController;

import model.*;

public class Main {

    public static final Map<Integer,User> users=new HashMap<>();
    public static final Map<Integer,Movie> movies=new HashMap<>();
    public static final Map<Integer, Theatre> theatres = new HashMap<>();
    public static final Map<Integer, Screen> screens = new HashMap<>();
    public static final Map<Integer, Show> shows = new HashMap<>();
    
    static{

        users.put(1,new User(1, "viswa", "123"));
        users.put(2,new User(2, "sudhir", "456"));
        users.put(3,new User(3,"peter", "789"));

        Movie movie1=new Movie(1, "Leo");
        Movie movie2=new Movie(2, "Vikram");
        Movie movie3=new Movie(3, "F1");
        Movie movie4=new Movie(4, "Petta");
        Movie movie5=new Movie(5, "Bison");

        movies.put(movie1.getMovieId(),movie1);
        movies.put(movie2.getMovieId(),movie2);
        movies.put(movie3.getMovieId(),movie3);
        movies.put(movie4.getMovieId(),movie4);
        movies.put(movie5.getMovieId(),movie5);

        Theatre t1=new Theatre(1, "KG");
        Theatre t2=new Theatre(2, "Inox");
        Theatre t3=new Theatre(3, "PVR");
        Theatre t4=new Theatre(4, "Miraj");
        Theatre t5=new Theatre(5, "Broadway");

        theatres.put(t1.getTheatreId(), t1);
        theatres.put(t2.getTheatreId(), t2);
        theatres.put(t3.getTheatreId(), t3);
        theatres.put(t4.getTheatreId(), t4);
        theatres.put(t5.getTheatreId(), t5);

        Screen s1=new Screen(1, 1, 30);
        Screen s2=new Screen(2, 2, 30);
        Screen s3=new Screen(3, 3, 30);
        Screen s4=new Screen(4, 4, 30);
        Screen s5=new Screen(5, 5, 30);
        Screen s6=new Screen(6, 5, 30);

        screens.put(s1.getScreenId(), s1);
        screens.put(s2.getScreenId(), s2);
        screens.put(s3.getScreenId(), s3);
        screens.put(s4.getScreenId(), s4);
        screens.put(s5.getScreenId(), s5);
        screens.put(s6.getScreenId(), s6);

         Show sh1 = new Show(1, 1, 1, 1,
                LocalDate.now(),
                LocalTime.of(10, 30),190);

        Show sh2 = new Show(2, 1, 1, 1,
                LocalDate.now(),
                LocalTime.of(14, 45),220);

        Show sh3 = new Show(3, 2, 2, 2,
                LocalDate.now(),
                LocalTime.of(18, 00),190);

        Show sh4 = new Show(4, 3, 3, 3,
                LocalDate.now().plusDays(1),
                LocalTime.of(20, 15),150);
         
        Show sh5 = new Show(5, 4, 4, 4,
                LocalDate.now().plusDays(1),
                LocalTime.of(13, 15),150);
         
        Show sh6 = new Show(6, 4, 4, 4,
                LocalDate.now(),
                LocalTime.of(9, 15),150);
         
        Show sh7 = new Show(7, 5, 5, 5,
                LocalDate.now().plusDays(1),
                LocalTime.of(11, 15),150);

        Show sh8 = new Show(8, 5, 5, 5,
                LocalDate.now().plusDays(1),
                LocalTime.of(9, 15),150);

        Show sh9 = new Show(9, 3, 5, 3,
                LocalDate.now().plusDays(1),
                LocalTime.of(9, 15),150);
         
        shows.put(sh1.getShowId(), sh1);
        shows.put(sh2.getShowId(), sh2);
        shows.put(sh3.getShowId(), sh3);
        shows.put(sh4.getShowId(), sh4);
        shows.put(sh5.getShowId(), sh5);
        shows.put(sh6.getShowId(), sh6);
        shows.put(sh7.getShowId(), sh7);
        shows.put(sh8.getShowId(), sh8);
        shows.put(sh9.getShowId(), sh9);
    }

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       UserController userController=new UserController();
       MovieController movieController=new MovieController();
       TheatreController theatreController=new TheatreController();
   
       ShowController showController=new ShowController();
       String movieName;
       String theatreName;
       int movieId;
       

        System.out.println("Book Your Tickets Now");
            while(true){    
            System.out.println("Login -> ");

            System.out.print("Enter username: ");
            String userName=sc.nextLine();

            System.out.print("Enter password: ");
            String password=sc.nextLine(); 

            int id=userController.validateUser(userName, password);

            if(id>0){
                System.out.println("\nLogin successFul! Welcome "+userName);
               
                 LocalDate date=null;
                boolean flag=false;
                do{
                    try{
                         System.out.println("\nEnter the date to view movies (yyyy-MM-dd):");
                        date=LocalDate.parse(sc.nextLine());
                       flag= movieController.displayMoviesByDate(date);
                    
                    }
                    catch(Exception e){
                        System.out.println("Invalid date! Enter again (yyyy-MM-dd):");
                    }
                }while(!flag);
               
                
                do{
                System.out.println("Select a Movie to watch: ");
                 movieName=sc.nextLine();
                }while ((theatreController.getMovieId(movieName)) == 0);
                 theatreController.displayTheatres(movieName,date);
                 do{
                System.out.print("\nSelect a Theatre: ");
                 theatreName=sc.nextLine();
                theatreController.displayTheatresShows(theatreName);
                 }while (theatreController.getTheatreId(theatreName)==0);

                 LocalTime showTime=null;
                movieId=theatreController.returnMovieId();
                 Thread t1=new Thread(()->{
                  Show show1 = showController.displaySeatsByShowTime( LocalTime.parse("14:45"), movieId,theatreController.getTheatreId("KG"),LocalDate.parse("2025-11-19"));
                    showController.bookSeats(new String[]{"A1", "A3"}, show1, 1);
                  
        }, "User-1");
       
                 Thread t2=new Thread(()->{
                  Show show2 = showController.displaySeatsByShowTime(LocalTime.parse("14:45"), movieId, theatreController.getTheatreId("KG"), LocalDate.parse("2025-11-19"));
                    showController.bookSeats(new String[]{"A1", "A3"}, show2, 2);
                    
                    
        }, "User-2");

        t1.start();
        t2.start();
                
        //    showTime=showController.getShowTime();
            //     movieId=theatreController.returnMovieId();
            // //    System.out.println("Movie Id: "+movieId+" TheatreId: "+theatreController.getTheatreId(theatreName)+" "+showTime+" "+date);
            //   Show currentShow= showController.displaySeatsByShowTime(showTime, movieId,theatreController.getTheatreId(theatreName),date);
            //     System.out.println("Enter seats (space or comma separated): ");
            //     String seatInput = sc.nextLine();
                
            //     String[] seatNumbers=seatInput.split("[, ]+");
            //     showController.bookSeats(seatNumbers,currentShow,id);
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    
                    e.printStackTrace();
                }
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    
                    e.printStackTrace();
                }
                for(Booking b:Booking.bookings.values()){
                    
                     int bookingId=b.getBookingId();
                     User u=Main.users.get(b.getUserId());
                     Show s=b.getShow();
                     Movie m=Main.movies.get(s.getMovieId());
                     Theatre t=Main.theatres.get(s.getTheatreId());
                     System.out.println("UserName: "+u.getUserName()+" BookingId: "+bookingId+" MovieName: "+m.getmovieName()+" TheatreName: "+t.getTheatreName()+" ShowTime: "+s.getShowTime()+" ShowDate: "+s.getShowDate()+" BookedSeats: "+b.getSeatNo());
                     
                }
                return;
            }
            else{
                System.out.println("Invalid username or password");
            }
            }
        
        }
    

    }

    

