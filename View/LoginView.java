package View;

import java.util.Scanner;

import Controller.LogInController;
import Model.User;

public class LoginView extends View {
    public LogInController logInController;
    public static User user;

    public static User getUserLogIn() {
        return user;
    }


    public LoginView() {
        this.scanner = new Scanner(System.in);

        logInController = new LogInController();
    }


    public boolean display() {
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

}
