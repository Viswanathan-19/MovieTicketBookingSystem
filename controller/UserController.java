package controller;

import view.Main;

public class UserController {
    
    public int validateUser(String userName,String userPassWord){
           for(Integer id:Main.users.keySet()){
              String name=Main.users.get(id).getUserName();
              String password=Main.users.get(id).getPassWord();
              if(name.equals(userName) && password.equals(userPassWord)){
                return id;
              }

           }
           return 0;
    }
}
