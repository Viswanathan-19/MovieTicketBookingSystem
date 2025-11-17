package model;

import java.time.*;

public class Show {

    private int showId;
    private int movieId;
    private int theatreId;
    private int screenId;
    private LocalDate showDate;
    private LocalTime showTime;
    private double ticketPrice;


    public Show(int showId, int movieId, int theatreId, int screenId, LocalDate showDate, LocalTime showTime,
            double ticketPrice) {
        this.showId = showId;
        this.movieId = movieId;
        this.theatreId = theatreId;
        this.screenId = screenId;
        this.showDate = showDate;
        this.showTime = showTime;
        this.ticketPrice = ticketPrice;
    }


    public int getShowId() {   return showId;  }


    public void setShowId(int showId) { this.showId = showId; }


    public int getMovieId() { return movieId;}


    public void setMovieId(int movieId) {  this.movieId = movieId;  }


    public int getTheatreId() {    return theatreId;}


    public void setTheatreId(int theatreId) {this.theatreId = theatreId; }


    public int getScreenId() { return screenId;  }


    public void setScreenId(int screenId) {this.screenId = screenId;}


    public LocalDate getShowDate() {   return showDate; }


    public void setShowDate(LocalDate showDate) {this.showDate = showDate; }


    public LocalTime getShowTime() { return showTime;}


    public void setShowTime(LocalTime showTime) {  this.showTime = showTime;}


    public double getTicketPrice() {  return ticketPrice;  }


    public void setTicketPrice(double ticketPrice) {  this.ticketPrice = ticketPrice; }

    
    

    
}
