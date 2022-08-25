package View;

import java.util.Scanner;

import Controller.RegistrationController;
import Model.User;

public class RegistrationView extends View{
    public RegistrationController registrationController;
    

    public RegistrationView() {
        this.registrationController = new RegistrationController();
        this.scanner = new Scanner(System.in);
    }

    public void signUp() {
        //username
        System.out.println("Hay nhap username: ");
        String userName = scanner.nextLine();
        if (registrationController.isUserExistence()) { // check co ton tai user nao khong
            while (registrationController.checkUserName(userName) == false) { // check username
                System.out.println("UserName nay bi trung, hay nhap lai: ");
                userName = scanner.nextLine();
            }
        }
        //password
        System.out.println("");
        System.out.println("Hãy nhập mật khẩu: ");
        System.out.println("Password dài từ 7 đến 15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt (. , - _ ;)");
        String password = scanner.nextLine();
        while ((registrationController.passwordPattern(password)) == false) {
            System.out.println("Mật khẩu không hợp lệ, hãy nhập lại mật khẩu: ");
            System.out.println(
                    "Password dài từ 7 đến 15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt (. , - _ ;)");
            password = scanner.nextLine();
        }
        //email
        System.out.println("");
        System.out.println("Hãy nhập email: ");
        String email = scanner.nextLine();
        if (registrationController.isUserExistence()) {
            while ((registrationController.emailPattern(email)) == false) {
                System.out.println("email không hợp lệ");
                System.out.println("Hãy nhập lại email: ");
                email = scanner.nextLine();

            }
           
        }

        // Tao user
        User user = new User(userName, email, password);
        System.out.println("");
        System.out.println("Ban da tao thanh cong User");

        registrationController.addUser(user);
        

    }


    
}
