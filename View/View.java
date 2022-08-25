package View;

import java.util.Scanner;
import java.util.regex.Pattern;

import Controller.UserController;
import Model.User;

public class View {
    public Scanner scanner;
    public UserController registrationController;
    public View view;

    public View() {
        // init scanner
        this.scanner = new Scanner(System.in);

        this.registrationController = new UserController();
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
                    if (registrationController.isUserExistence()) {
                        
                        User user = signIn();
                        
                        if (login(user.getUserName()) == 1) {
                            isQuit = true;
                            break;
                        }else{
                            login(user.getUserName());
                        }
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
                    if (isQuit = true) {
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
                return true;
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
        int count = 0;
        boolean isBoolean = false;
        System.out.println("Hay nhap ten dang nhap");
        String userName = scanner.nextLine();
        while (registrationController.checkUserName(userName) == false) { // check username
            System.out.println("Không tồn tại username này, hãy nhập lại: " + " Lần thứ: " + (count + 1));  
    // Nhập sai 3 lần sẽ bị kick
            userName = scanner.nextLine();
            count++;
                if(count == 3) {
                    System.out.println("Vui long quay lai trang chu");
                    System.out.println("============================================================");
                    display();
                }
        }
        user = registrationController.getUserByName(userName);
        System.out.println("Hay nhap password: ");
        String password = scanner.nextLine();
        // check password

        while (registrationController.checkPassword(password) == false) {
            System.out.println("Sai password");
            System.out.println("[1] Đăng nhập lại");
            System.out.println("[2] Quên mật khẩu");
            int num = scanner.nextInt();
            scanner.nextLine();
            switch (num) {
                case 1: {
                    do {
                        System.out.println("Hay nhap password lai: ");
                        System.out.println("Nhap qua 3 lan sai se bi khoa: lan thu: " + (count + 1));
        // Nhập sai 3 lần sẽ bị kick
                        password = scanner.nextLine();
                        count++;
                        if(count == 3) {
                            break;
                        }
                    } while (registrationController.checkPassword(password) == false);
        // Nhập sai 3 lần sẽ bị kick
                    if (count == 3) {
                        System.out.println("====================================================================");
                        System.out.println("Ban da nhap sai qua 3 lan");
                        System.out.println("vui long dang nhap bang email");
                        forgotPassword(userName);
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

        return registrationController.getUser(user);

    }

    // forgot password
    public void forgotPassword(String userName) {
        System.out.println("Hay nhap email cua ban: ");
        String email = scanner.nextLine();
        int count = 0;
        while (true) {
            if (registrationController.checkEmail(email)) {
                System.out.println("Da gui lai mat khau cua ban theo email");
                login(userName);
                break;
            } else {
                System.out.println("email khong dung, xin hay nhap lai: " + "(Lan thu " + (count + 1) + ")");
                email = scanner.nextLine();
    // Nhập sai 3 lần sẽ bị kick
                count++;
                if(count == 3) {
                    System.out.println("Vui long quay lai trang chu");
                    System.out.println("============================================================");
                    display();
                }
            }
        }
    }

    // dang ky
    public void signUp() {
        System.out.println("Hay nhap username: ");
        String userName = scanner.nextLine();
        if (registrationController.isUserExistence()) { // check co ton tai user nao khong
            while (registrationController.checkUserName(userName) == false) { // check username
                System.out.println("UserName nay bi trung, hay nhap lai: ");
                userName = scanner.nextLine();
            }
        }
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

        System.out.println("");
        System.out.println("Hãy nhập email: ");
        String email = scanner.nextLine();
        if (registrationController.isUserExistence()) {
            while ((registrationController.emailPattern(email)) == false) {
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

        registrationController.addUser(user);
        

    }

    // View2
    public User view2() {
        User user = signIn();
        return user;

    }
    // Man hinh sau khi login thanh cong
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
        user = registrationController.getUser(user);
        while (registrationController.checkUserName(userName) == false) { // check username
            System.out.println("username này bị trùng, hay nhap lai");
            userName = scanner.nextLine();
        }
        user.setUserName(userName);
        System.out.println("Ten moi cua ban la: " + user.getUserName());

    }

    // Change email
    public void changeUserEmail(String email, User user) {
        user = registrationController.getUser(user);
        boolean validEmail = registrationController.checkEmailTochangeEmail(email);
        while (validEmail == false) { // check email trung
            System.out.println("email khong phu hop, hay nhap lai");
            email = scanner.nextLine();
            validEmail = registrationController.checkEmailTochangeEmail(email);
        }
        
        user.setEmail(email);
        System.out.println("email moi cua ban la: " + user.getEmail());
        
    }

    // Change password
    public void changePassWord(String passWord, User user) {
        user = registrationController.getUser(user);
        // User userTest = new User();
        // userTest.setPassword(passWord);
        
        boolean validPassword = registrationController.checkPasswordTochangePass(passWord);
        while (validPassword == false ) { // check password trung
            System.out.println("password không phù hợp, hay nhap lai");
            passWord = scanner.nextLine();
            validPassword = registrationController.checkPasswordTochangePass(passWord);
        }
    // Check password pattern
        
       
        user.setPassword(passWord);
        System.out.println("pass moi cua ban la: " + user.getPassword());
    }

    // login
    public int login(String userName) {
        int i =0;
        boolean isBoolean = false;
        User user = registrationController.getUserByName(userName);
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
                    login(userName);
                    break;
                }
                case 2: {
                    System.out.println("Hay nhap email moi:");
                    String email = scanner.nextLine();
                    changeUserEmail(email, user);
                    login(userName);
                    break;
                }
                case 3: {
                    System.out.println("Hay nhap password moi:");
                    String passWord = scanner.nextLine();
                    changePassWord(passWord, user);
                    login(userName);
                    break;
                }
                case 4: {
                    display();
                    break;
                }
                case 0: {  
                    isBoolean = true;
                    i = 1;
                    return i;
                }
                default:
                    login(userName);
            }
            if (isBoolean = true) {
                break;
            }
        }
        return i;
    }
}
