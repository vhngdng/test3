package View;

import java.util.Scanner;
import Model.User;

public class View {
    public static Scanner scanner = new Scanner(System.in);

    public View view;
    public LoginView loginView;
    public RegistrationView registrationView;

    public View() {
    }

    public View(User user) {

    }

    public static boolean display() {
        boolean isQuit = false;
        while (true) {
            boolean isBoolean = false;
            displaySelection();
            int numberSelect = scanner.nextInt();
            scanner.nextLine();
            switch (numberSelect) {
                case 1: {
                    LoginView.display();
                    break;
                }
                case 2: {
                    RegistrationView.signUpDisplay();
                    break;
                }
                default:
                    break;
            }
            
        }
    }

    // display register or sign in
    public static void displaySelection() {
        System.out.println("[1] - Đăng nhập");
        System.out.println("[2] - Đăng ký");
        finishLine();
    }

    private static void finishLine() {
        System.out.println("=========================================================");
    }


}
