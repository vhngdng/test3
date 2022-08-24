package View;

import java.util.Scanner;
import java.util.regex.Pattern;

import Controller.UserController;
import Model.User;

public class View {
    private Scanner scanner;
    private UserController userController;
    private View view;

    public View() {
        // init scanner
        this.scanner = new Scanner(System.in);

        this.userController = new UserController();
    }

    public View(User user) {

    }

    public boolean display() {
        boolean isQuit = false;
        while (true) {
            boolean isBoolean = false;
            displaySelection();
            int numberSelect = scanner.nextInt();
            scanner.nextLine();
            switch (numberSelect) {
                case 1: {
                    if (userController.isUserExistence()) {

                        User user = signIn();
                        login(user.getUserName());
                    } else {
                        System.out.println("");
                        System.out.println("Chưa tồn tại user nào");
                        System.out.println("==================================================================");
                        System.out.println("Hãy đăng ký trước đã, vui lòng chọn 2");
                        System.out.println("");
                        break;
                    }
                    if (isBoolean == true) {
                        System.out.println("Quay lai menu chinh");
                        System.out.println("==================================================================");
                        break;
                    }
                }
                case 2: {
                    signUp();
                    System.out.println("Quay lai menu chinh");
                    System.out.println("==================================================================");
                    break;
                }
                default:
                    break;

            }
            if (isQuit == true) {
                this.quit();
            }

        }
    }

    // display register or sign in
    public void displaySelection() {
        System.out.println("[1] - Đăng nhập");
        System.out.println("[2] - Đăng ký");
    }

    // dang nhap
    public User signIn() {
        User user = new User();
        boolean isBoolean = false;
        System.out.println("Hay nhap ten dang nhap");
        String userName = scanner.nextLine();
        while (userController.checkUserName(userName) == false) { // check username
            System.out.println("Kiem tra lai username");
            userName = scanner.nextLine();
        }

        System.out.println("Hay nhap password: ");
        String password = scanner.nextLine();
        // check password
        while (userController.checkPassword(password) == false) {
            System.out.println("Sai password");
            System.out.println("[1] Đăng nhập lại");
            System.out.println("[2] Quên mật khẩu");
            int num = scanner.nextInt();
            scanner.nextLine();
            switch (num) {
                case 1: {
                    while (userController.checkPassword(password) == false) {
                        System.out.println("Hay nhap password: ");
                        password = scanner.nextLine();
                    }
                    break;
                }
                case 2: {
                    forgotPassword(userName);
                    isBoolean = true;
                    break;
                }
                default:
                    break;
            }
            if (isBoolean = false) {
                break;
            }
        }
        user.setUserName(userName);
        return userController.getUser(user);

    }

    // forgot password
    public void forgotPassword(String userName) {
        System.out.println("Hay nhap email cua ban: ");
        String email = scanner.nextLine();

        while (true) {
            if (userController.checkEmail(email)) {
                System.out.println("Da gui lai mat khau cua ban theo email");
                login(userName);
                break;
            } else {
                System.out.println("email khong dung, xin hay nhap lai: ");
                email = scanner.nextLine();
            }
        }
        displaySelection();
    }

    // dang ky
    public void signUp() {
        System.out.println("Hay nhap username: ");
        String userName = scanner.nextLine();
        if (userController.isUserExistence()) { // check co ton tai user nao khong
            while (userController.checkUserName(userName) == false) { // check username
                System.out.println("Kiem tra lai username");
                userName = scanner.nextLine();
            }
        }
        System.out.println("");
        System.out.println("Hãy nhập mật khẩu: ");
        System.out.println("Password dài từ 7 đến 15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt (. , - _ ;)");
        String password = scanner.nextLine();
        while ((userController.passwordPattern(password)) == false) {
            System.out.println("Mật khẩu không hợp lệ, hãy nhập lại mật khẩu: ");
            System.out.println(
                    "Password dài từ 7 đến 15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt (. , - _ ;)");
            password = scanner.nextLine();
        }

        System.out.println("");
        System.out.println("Hãy nhập email: ");
        String email = scanner.nextLine();
        if (userController.isUserExistence()) {
            while ((userController.emailPattern(email)) == false) {
                System.out.println("email không hợp lệ");
                System.out.println("Hãy nhập lại email: ");
                email = scanner.nextLine();

            }
            // check co ton tai user nao khong
        }

        // Tao user
        User user = new User(userName, email, password);
        System.out.println("");
        System.out.println("Ban da tao thanh cong User");

        userController.addUser(user);

    }

    // View2
    public User view2() {
        User user = signIn();
        return user;

    }

    public void displayMenuLogin() {
        System.out.println("[1] - Thay đổi username");
        System.out.println("[2] - Thay đổi email");
        System.out.println("[3] - Thay đổi mật khẩu");
        System.out.println("[4] - Đăng xuất (Sau khi đăng xuất quay về mục yêu cầu đăng nhập hoặc đăng ký)");
        System.out.println("[0] - Thoát chương trình");
    }

    /**
     * system quit
     */
    private void quit() {
        System.out.println("Hen gap lai !!!");
        this.close();
    }

    // close view
    public void close() {
        if (this.scanner != null) {
            this.scanner.close();
        }
    }

    // change userName
    public void changeUserName(String userName, User user) {
        user = userController.getUser(user);
        while (userController.checkUserName(userName) == true) { // check username
            System.out.println("username này bị trùng, hay nhap lai");
            userName = scanner.nextLine();
        }
        user.setUserName(userName);
        System.out.println("Ten moi cua ban la: " + user.getUserName());

    }

    // Change email
    public void changeUserEmail(String email, User user) {
        user = userController.getUser(user);
        while (userController.checkEmail(email) == true) { // check email trung
            System.out.println("email này bị trùng, hay nhap lai");
            email = scanner.nextLine();
        }
        user.setEmail(email);
        System.out.println("email moi cua ban la: " + user.getEmail());
    }

    // Change password
    public void changePassWord(String passWord, User user) {
        user = userController.getUser(user);
        ;

        while (userController.checkPassword(passWord) == false) { // check password trung
            System.out.println("password này bị trùng, hay nhap lai");
            passWord = scanner.nextLine();
        }
        user.setPassword(passWord);
        System.out.println("pass moi cua ban la: " + user.getPassword());
    }

    // login
    public void login(String userName) {
        boolean isQuit = false;
        boolean isBoolean = false;
        User user = userController.getUserByName(userName);
        System.out.println("Chao mung " + user.getUserName() + ", bạn có thể thực hiện các công việc sau: ");
        while (true) {
            displayMenuLogin();
            int num = scanner.nextInt();
            scanner.nextLine();
            switch (num) {
                case 1: {
                    System.out.println("Hay nhap username moi:");
                    userName = scanner.nextLine();
                    changeUserName(userName, user);
                    isBoolean = true;
                    break;
                }
                case 2: {
                    System.out.println("Hay nhap email moi:");
                    String email = scanner.nextLine();
                    changeUserEmail(email, user);
                    isBoolean = true;
                    break;
                }
                case 3: {
                    System.out.println("Hay nhap password moi:");
                    String passWord = scanner.nextLine();
                    changePassWord(passWord, user);
                    isBoolean = true;
                    break;
                }
                case 4: {
                    break;
                }
                case 0: {
                    isQuit = true;
                    displaySelection();
                }
                default:
                    displaySelection();
            }
            if (isBoolean = true) {
                break;
            }
        }
    }
}
