package View;

import java.util.Scanner;

import Controller.LogInController;
import Model.User;

public class LoginView {
    public static LogInController logInController;
    // public static User user;
    private static Scanner scanner = new Scanner(System.in);

    // public static User getUserLogIn() {
    // return user;
    // }

    // finish line
    public static void finishLine() {
        System.out.println("=========================================================");
    }

    public static void display() {
        System.out.println("Hay nhap ten dang nhap");
        String userName = scanner.nextLine();
        System.out.println("Hay nhap password: ");
        String password = scanner.nextLine();
        finishLine();
        LogInController.logIn(userName, password);
    }

    // show login menu
    public static void displayMenuLogin() {
        System.out.println("");
        System.out.println("[1] - Thay đổi username");
        System.out.println("[2] - Thay đổi email");
        System.out.println("[3] - Thay đổi mật khẩu");
        System.out.println("[4] - Đăng xuất (Sau khi đăng xuất quay về mục yêu cầu đăng nhập hoặc đăng ký)");
        System.out.println("[0] - Thoát chương trình");
    }

    public static boolean userLoginDisplay(User user) {
        System.out.println("Chao mung " + user.userName + ", bạn có thể thực hiện các công việc sau: ");
        while (true) {
            boolean isQuit = false;
            displayMenuLogin();
            int num = scanner.nextInt();
            scanner.nextLine();
            switch (num) {
                case 1: {
                    while (true) {
                        System.out.println("Hay nhap username moi:");
                        String userName = scanner.nextLine();
                        if (LogInController.changeUserName(userName) == true) {
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    while (true) {
                        System.out.println("Hay nhap email moi:");
                        String email = scanner.nextLine();
                        if (LogInController.changeEmail(email) == true) {
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    while (true) {
                        System.out.println("Hay nhap password moi:");
                        String passWord = scanner.nextLine();
                        if (LogInController.changePassword(passWord) == true) {
                            break;
                        }
                    }
                    break;
                }
                case 4: {
                    finishLine();
                    View.display();
                    break;
                }
                case 0: {
                    quit();
                    finishLine();
                    isQuit = true;
                }

            }
            if (isQuit == true) {
                scanner.close();
            }
        }
    }

    public static void PasswordFail(String userName) {
        System.out.println("[1] - Đăng nhập lại");
        System.out.println("[2] - Quên email");
        finishLine();
        int num = scanner.nextInt();
        scanner.nextLine();
        switch (num) {
            case 1: {
                displayLoginPasswordFail(userName);
                break;
            }
            case 2: {
                LoginWithEmail(userName);
                break;
            }
            default:

        }
    }

    public static void displayLoginPasswordFail(String userName) {
        System.out.println("Hay nhap lai mat khau");
        String password = scanner.nextLine();
        LogInController.logIn(userName, password);
    }

    public static void LoginWithEmail(String userName) {
        System.out.println("Hay nhap Email");
        String email = scanner.nextLine();
        logInController.LoginWithEmail(userName, email);
    }

    private static void quit() {
        System.out.println("Hen gap lai !!!");

    }

    // close view

}
