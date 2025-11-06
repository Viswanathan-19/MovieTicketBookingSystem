package controller;

import model.*;
import java.util.*;

public class TheatreController {
      Scanner sc=new Scanner(System.in);
    public String displayTheatres(String movieName){
        System.out.println("\n"+movieName+" is Available in These Theatres->");
        List<Theatre> t=StoreData.theatre.get(movieName);
        for(Theatre th:t){
            System.out.println(th.getTheatreName());
        }
        System.out.print("Please Select the theatre to watch: ");
        String theatre=sc.nextLine();
        return theatre;
    }
}
