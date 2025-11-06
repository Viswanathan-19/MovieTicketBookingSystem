package model;

public class Theatre {
    
    private String theatreName;
    private int theatreId; 
     
    public Theatre(String theatreName, int theatreId) {
        this.theatreName = theatreName;
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    

    
}
