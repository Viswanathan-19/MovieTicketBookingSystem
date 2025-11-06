package model;

import java.util.*;


public class StoreData {
    public static final List<User> users = new ArrayList<>();
    public static final List<Movie> movies = new ArrayList<>();
    public static final Map<String,List<Theatre>> theatre = new HashMap<>();


    static{
        users.add(new User("viswa", "1234"));
        users.add(new User("sudhir", "5678"));
        users.add(new User("vishal", "91011"));
        users.add(new User("peter", "1213"));

        movies.add(new Movie("Vikram", 144));
        movies.add(new Movie("Leo", 110));
        movies.add(new Movie("F1", 156));
        movies.add(new Movie("ShutterIsland", 95));
        movies.add(new Movie("Petta", 167));

        theatre.put(movies.get(0).getMovieName(),List.of(new Theatre("KgCinemas", 1),new Theatre("PVR", 2),new Theatre("Cinepolis", 3),new Theatre("Inox", 4),new Theatre("Miraj", 5)));
        theatre.put(movies.get(1).getMovieName(),List.of(new Theatre("Karpagam", 1),new Theatre("Imax", 2),new Theatre("Cinepolis", 3),new Theatre("Kumaran", 4),new Theatre("Cosmos", 5)));
        theatre.put(movies.get(2).getMovieName(),List.of(new Theatre("PVR", 1),new Theatre("Shanthi", 2),new Theatre("Miraj", 3),new Theatre("Inox", 4),new Theatre("Diamond", 5)));
        theatre.put(movies.get(3).getMovieName(),List.of(new Theatre("Kalpana", 1),new Theatre("PVR", 2),new Theatre("Srinivas", 3),new Theatre("Inox", 4),new Theatre("SriShakthi", 5)));
        theatre.put(movies.get(4).getMovieName(),List.of(new Theatre("SenthilKumaran", 1),new Theatre("Inox", 2),new Theatre("Cinepolis", 3),new Theatre("Diamond", 4),new Theatre("Sivan", 5)));
       
      
    }

}
