package View;

import java.util.Scanner;

import Controller.RegistrationController;
import Model.User;

public class RegistrationView{
    public static Scanner scanner;
    public RegistrationController registrationController;

    public RegistrationView() {
        this.registrationController = new RegistrationController();
        
        // Error
        // inputFields
    }

    public static void signUpDisplay() {
        // username
        scanner = new Scanner(System.in);
        System.out.println("Hay nhap username: ");
        String userName = scanner.nextLine();

        //password
        System.out.println("");
        System.out.println("Hãy nhập mật khẩu: ");
        System.out.println("Password dài từ 7 đến 15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt (. , - _ ;)");
        String password = scanner.nextLine();

        // email
        System.out.println("");
        System.out.println("Hãy nhập email: ");
        String email = scanner.nextLine();

        RegistrationController.createUser(userName, password, email);

    }
}
