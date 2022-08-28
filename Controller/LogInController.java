package Controller;

import Model.User;
import View.LoginView;

public class LogInController{
    public String userName;
    public String password;
    // public static User userLogin;
    public User user;
    public LogInController() {

    }


    public static void logIn(String userName, String password){
        User user = new User(userName, password);
        User.validUserLogin(user);
    }

    public static boolean changeUserName(String userName){
        return User.changeUserName(userName);
    }

    public static boolean changeEmail(String email) {
        return User.changeEmail(email);
    }


    public static boolean changePassword(String password) {
        return User.changePassword(password);
    }

    public void LoginWithEmail(String userName, String email) {
        User user = new User(email);
        user.setUserName(userName);
        User.validUserLogin(user);
    }


    public static void PasswordFail(String userName) {
        LoginView.displayLoginPasswordFail(userName);
    }
}
