package model;

public class Seat {
    private int seatNo;
    private int screenId;
    private Show show;
    
    public Seat(int seatNo, int screenId, Show show) {
        this.seatNo = seatNo;
        this.screenId = screenId;
        this.show = show;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    

}
