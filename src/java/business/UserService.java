package business;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import business.User;

/**
 *
 * @author 709317
 */
public class UserService {
    
//    public boolean login(String username,String password)
//    {
//       // User user = null;
//        
//        return(username.equals("adam") && password.equals("password"))||
//                (username.equals("betty") && password.equals("password"));
//            
//           // user = new User(username,password);
//     
//     
//    }
    
 public String login(User user){
     String username = user.getUsername();
     String password = user.getPassword();
     
     if(username != null && password != null && !username.equals("")&& !password.equals("")
        && (username.equals("adam") && password.equals("password")
        || username.equals("betty") && password.equals("password"))){
     
         
         return username;
 }
 
    return null;
 
 }
 
}
