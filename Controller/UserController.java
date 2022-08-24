package Controller;

import java.util.regex.Pattern;

import Model.User;;

public class UserController {
    private User user;

    //check Username bi trung
    public boolean checkUserName(String userName) {
        boolean isDuplicate = user.checkUserName(userName);
        return isDuplicate;
    }
    
    // Check Password bi trung
    public boolean checkPassword(String password) {
        boolean isDuplicate = user.checkPassword(password);
        return isDuplicate;
    }

    //Check email bi trung
    public boolean checkEmail(String email) {
        boolean isDuplicate = user.checkEmail(email);
        return isDuplicate;
    }

    //Check user co ton tai khong
    public boolean isUserExistence () {
        boolean isUserExistence = (user != null);
        return isUserExistence;
    }

    // check password theo mau
    public boolean passwordPattern(String password) {
        String passwordPattern = "^(?=.*?[A-Z])+(?=.*?[.,-_;]).{7,15}$";
        boolean isValid = Pattern.matches(passwordPattern, password);
        System.out.println(isValid);
        return isValid;
    }

    //Check email theo mau
    public boolean emailPattern(String email) {
        String emailPattern = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,}$";
        boolean isValid = Pattern.matches(emailPattern, email);
        return isValid;
    }

    public User addUser(User userNew) {
        user = userNew;
        user.addUser(user);
        return user;
    }

    public User getUserByName (String userName) {
        return this.user.getUser(userName);
    }

    public User getUser(User user) {

        return this.user.getUser(user.getUserName());
    }
}
