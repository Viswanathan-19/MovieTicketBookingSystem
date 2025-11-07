package model;

import java.time.*;
import java.util.*;

public class StoreData {
    public static final List<User> users = new ArrayList<>();
    public static final List<Movie> movies = new ArrayList<>();
    public static final List<List<Theatre>> theatres = new ArrayList<>();
    public static final Map<String, List<Theatre>> theatre = new HashMap<>();
    public static final Map<String, Map<String,List<Show>>> shows = new HashMap<>();   //Theatre->movie->shows

    public static final List<LocalTime> defaultShowTimes = Arrays.asList(
        LocalTime.of(10, 0),
        LocalTime.of(13, 30),
        LocalTime.of(16, 0),
        LocalTime.of(19, 30)
    );

    static {
        users.add(new User("viswa", "1234"));
        users.add(new User("sudhir", "5678"));
        users.add(new User("vishal", "91011"));
        users.add(new User("peter", "1213"));

        movies.add(new Movie("Vikram", 144,1));
        movies.add(new Movie("Leo", 110,2));
        movies.add(new Movie("F1", 156,3));
        movies.add(new Movie("ShutterIsland", 95,4));
        movies.add(new Movie("Petta", 167,5));

      theatres.add(List.of(new Theatre("KgCinemas", 1),new Theatre("PVR", 2),new Theatre("Cinepolis", 3),new Theatre("Inox", 4),new Theatre("Miraj", 5))); 
      theatres.add(List.of(new Theatre("Karpagam", 6),new Theatre("Imax", 7),new Theatre("Cinepolis", 3),new Theatre("Kumaran", 8),new Theatre("Cosmos", 9))); 
      theatres.add(List.of(new Theatre("PVR", 2),new Theatre("Shanthi", 10),new Theatre("Miraj", 5),new Theatre("Inox", 4),new Theatre("Diamond", 11))); 
      theatres.add(List.of(new Theatre("Kalpana", 2),new Theatre("PVR", 2),new Theatre("Srinivas", 13),new Theatre("Inox", 4),new Theatre("SriShakthi", 14)));
      theatres.add(List.of(new Theatre("SenthilKumaran", 15),new Theatre("Inox", 4),new Theatre("Cinepolis", 3),new Theatre("Diamond", 11),new Theatre("Sivan", 16)));

        for (int i = 0; i < movies.size(); i++) {
            theatre.put(movies.get(i).getMovieName(), theatres.get(i));
        }

        for(Movie movie:movies){                    //get the movie obj
            Map<String,List<Show>>theatreShows=new HashMap<>();  //create the innerHashMap(theatreName,List<Shows>)
            List<Theatre> movieTheatres=theatre.get(movie.getMovieName());  //get the list of theatres for that particular movie

            if(movieTheatres!=null){
                for(Theatre t:movieTheatres){           //for each theatre set show timings for particular movie
                    List<Show> showList=new ArrayList<>();   //create a list of shows

                    for(LocalTime time:defaultShowTimes){     //create diff show timings
                        int screenNo=new Random().nextInt(3)+1;
                        int seats=60;
                        showList.add(new Show(movie, t, screenNo, time, seats));  //create a show

                    }
                    theatreShows.put(t.getTheatreName(),showList);    //link theatrename->multiple shows

                   
                }
                shows.put(movie.getMovieName(),theatreShows);   //link movie->multipletheatres->multiple shows
            }

        }
       

            
        
      

    }

    }

