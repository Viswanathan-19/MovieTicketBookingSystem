package controller;
import model.*;

public class UserController {

    public boolean authenticate(String username, String password) {
        for (User u : StoreData.users) {
            if (u.getUserName().equals(username) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
