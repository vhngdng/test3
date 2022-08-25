package Controller;

import Model.User;

public class RegistrationController extends UserController{
    public User user;



    public User addUser(User userNew) {
        
        user.addUser(userNew);
        return user;
    }

    // check password theo mau
    public boolean passwordPattern(String password) {
        return user.passwordPattern(password);
        // boolean isValid = Pattern.matches(passwordPattern, password);
        // System.out.println(isValid);
        // return isValid;
    }
}
