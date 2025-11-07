package model;

import java.time.LocalTime;

public class Show {
    private Movie movie;
    private Theatre theatre;
    private int screenNumber;
    private LocalTime showTime;
    private volatile int availableSeats;

    public Show(Movie movie, Theatre theatre, int screenNumber, LocalTime showTime, int availableSeats) {
        this.movie = movie;
        this.theatre = theatre;
        this.screenNumber = screenNumber;
        this.showTime = showTime;
        this.availableSeats = availableSeats;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public int getScreenNumber() {
        return screenNumber;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

  
}
