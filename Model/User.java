package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class User {
    private String userName;
    private String email;
    private String password;
    private int id;
    
    public static int USER_COUNT = 0;
    public static User user;
    List<User> userList = new ArrayList<>();
    


    public User() {
        
    }


    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    
        
     


    public String getUserName() {
        return userName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public int getId() {
        return this.id;
    }    

     public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    
    public int getAllUser(){        
        return USER_COUNT;
    }
    

    public User addUser(User user){
        this.userList.add(user);
        int id = USER_COUNT + 1;
        user.setId(id);
        return user;
    }


    //check username 
    public boolean checkUserName(String userName) {
        boolean isDuplicate = false;
        Iterator<User>iteratorUser = userList.iterator();        
        while (iteratorUser.hasNext()){
            isDuplicate = (iteratorUser.next()).getUserName().equalsIgnoreCase(userName);
            if (isDuplicate == true) {
                return isDuplicate;
            }
        }        
        return isDuplicate;
    }    

    //check password
    public boolean checkPassword(String password) {
        boolean isDuplicate = false;
        User user = new User();
        Iterator<User>iteratorUser = userList.iterator();        
        while (iteratorUser.hasNext()){
            isDuplicate = (iteratorUser.next()).getPassword().equals(password);
            if (isDuplicate == true) {
                
                break;
            }
        }     
         
        return isDuplicate;
    }

    //check email
    public boolean checkEmail(String email) {
        boolean isDuplicate = false;
        Iterator<User>iteratorUser = userList.iterator();        
        while (iteratorUser.hasNext()){
            isDuplicate = (iteratorUser.next()).getEmail().equals(email);
            if (isDuplicate == true) {
                return isDuplicate;        
            }
        }        
        return isDuplicate;
    }

    public User getUser(String userName) {
        User user = new User();
        boolean isDuplicate = false;
               
        for (User listUser: userList){
            isDuplicate = listUser.getUserName().equals(userName);
            if (isDuplicate == true) {
                user = listUser; 
                return user;
            }
        }              
        
        return user;
    }
}
