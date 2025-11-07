package model;

public class Movie {
    
    private String movieName;
    private int movieId;
    private int durationInMin;

    

    public Movie(String movieName, int durationInMin,int movieId) {
        this.movieName = movieName;
        this.movieId=movieId;
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


    public int getMovieId() {
        return movieId;
    }


    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    

    
    
}
