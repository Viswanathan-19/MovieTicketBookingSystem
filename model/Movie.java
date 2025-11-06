package model;

public class Movie {
    
    private String movieName;
    
    private int durationInMin;

    

    public Movie(String movieName, int durationInMin) {
        this.movieName = movieName;
        
        this.durationInMin = durationInMin;
    }


    public String getMovieName() {
        return movieName;
    }


    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }


    

    public int getDuration() {
        return durationInMin;
    }


    public void setDuration(int durationInMin) {
        this.durationInMin = durationInMin;
    }

    
    
}
