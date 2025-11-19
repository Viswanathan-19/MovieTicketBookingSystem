package model;

import java.util.HashMap;
import java.util.*;

public class Booking {
    private int userId;
    private int bookingId;
    private Show show;

    private List<String>seatNo;

    public static Map<Integer,Booking>bookings=new HashMap<>();

    public Booking(int bookingId, Show show,int userId,List<String> seatNo) {
        this.bookingId = bookingId;
        this.show = show;
        this.userId=userId;
        this.seatNo=seatNo;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

   
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<String> getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(List<String> seatNo) {
        this.seatNo = seatNo;
    }

    
    
}
