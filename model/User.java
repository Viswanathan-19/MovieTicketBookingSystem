package model;

import java.util.*; 
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    
    private AtomicInteger userId=new AtomicInteger(0);
    private String userName;
    private String password;



    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
  



}
