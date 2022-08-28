package Controller;

import Model.User;

public class RegistrationController {
    public User user;
    // {name: fefe, phone: fef}
    // public User addUser(params) {
    // user = new User(params)
    // user.valid? // {:"fefefef"
    // User.addUser(user)
    // Print success
    // new LoginVIew(params).render_login_form
    // else
    // Print "error"
    // user.Error
    // HOmepage
    // chuyen sang man dang ky
    // chuyen sang man login new RegistrationView(params, Error).render_signup_form
    // end

    public static void createUser(String userName, String password, String email) {
        User user = new User(userName, email, password);
        User.createUser(user);
    }

}
