package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.regex.Pattern;

import Controller.LogInController;
import View.LoginView;
import View.View;

public class User {
    public String userName;
    public String email;
    public String password;
    public int id;
    public LoginView loginView;
    public static int j = 0;
    public static int i = 0;
    public static int USER_COUNT = 0;
    public static User user;
    public static List<User> userList = new ArrayList<>();
    public final String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
    public final String passwordPattern = "^(?=.*?[A-Z])(?=.*?[.,-_;]).{7,15}$";

    public User() {

    }

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User ( String email) {
        
        this.email = email;
    } 

    public void setId(int id) {
        this.id = id;
    }

    public int getAllUser() {
        return USER_COUNT;
    }

    private static void finishLine() {
        System.out.println("=========================================================");
    }

    public static int addUser(User user) {
        userList.add(user);
        int id = USER_COUNT + 1;
        user.setId(id);
        USER_COUNT += 1;
        return user.id;
    }

    // Tao user moi neu thanh cong thi add user vao list
    public static void createUser(User user) {
        // check user
        System.out.println("");
        if (User.checkUserName(user.userName)) {
            System.out.println("user name bị trùng");
        } else {
            System.out.println("user name phù hợp");
        }

        // check password
        if (user.passwordPattern(user.password) == false) {
            System.out.println("password sai mẫu");
        } else {
            System.out.println("password phù hợp");
        }

        // check email
        if (user.checkEmailTochangeEmail(user.email) == false) {
            System.out.println("Email không phù hợp");
        } else {
            System.out.println("Email phu hop");
        }
        System.out.println("");
        if (User.checkUserName(user.userName) == false && user.passwordPattern(user.password) == true
                && user.checkEmailTochangeEmail(user.email) == true) {
            System.out.println("Tạo user thành công");
            addUser(user);
            System.out.println(User.USER_COUNT);
        } else {
            System.out.println("");
            System.out.println("Tao user không thành công");
        }
        finishLine();
        View.display();
    }

    // private boolean checkEmailRegistration(String email2) {
    //     return false;
    // }

    // check username
    public static boolean checkUserName(String userName) {
        boolean isDuplicate = false;
        Iterator<User> iteratorUser = userList.iterator();
        if (isUserExistence() == true) {
            while (iteratorUser.hasNext()) {
                isDuplicate = (iteratorUser.next()).userName.equalsIgnoreCase(userName);
                if (isDuplicate == true) {
                    return isDuplicate;
                }
            }
        }
        return isDuplicate;
    }

    // check password
    private static boolean checkPasswordDuplicate(String password, User user) {
        if (User.user == null) {
            return false;
        }
        boolean isDuplicate = user.password.equals(password);
        return isDuplicate;
    }

    // check email trung
    private boolean checkEmail(String email) {
        boolean isDuplicate = false;
        Iterator<User> iteratorUser = userList.iterator();
        if (isUserExistence()) {
            while (iteratorUser.hasNext()) {
                isDuplicate = (iteratorUser.next()).email.equals(email);
                if (isDuplicate == true) {
                    System.out.println("Email bị trùng");
                    return isDuplicate;
                }
            }
        }
        return isDuplicate;
    }

    // Check user Login
    public static void validUserLogin(User user) {
        boolean isUserLoginUserNameValid = checkUserName(user.userName); 
        if (isUserLoginUserNameValid == false) {
            System.out.println("username sai");
        } else {
            for (User listUser : userList) {
                if (listUser.userName.equals(user.userName)) {
                    User.user = listUser;
                    break;
                }
            }
        }
        boolean isUserLoginPasswordValid = checkPasswordDuplicate(user.password, user);
        if (isUserLoginPasswordValid == false) {
            System.out.println("password sai");
        }

        if (isUserLoginPasswordValid == false && isUserLoginUserNameValid == true) {
            j++;
            System.out.println("password sai lần " + j);
            if (j == 3) {
                System.out.println("");
                System.out.println("Ban da nhap sai 3 lan");
                j = 0;
                finishLine();
                View.display();
            }
            LogInController.PasswordFail(user.userName);
            
            
        }

        if (isUserLoginUserNameValid == true && isUserLoginPasswordValid == true) {
            LoginView.userLoginDisplay(User.user);
        } else {
            System.out.println("Xin moi nhap lai");
            i++;
            if (i == 3) {
                System.out.println("Ban da nhap sai 3 lan, vui long quay lai trang chu");
                View.display();
            }
            LoginView.display();
        }
    }
    // check password theo mau
    public boolean passwordPattern(String password) {
        boolean isValid = Pattern.matches(passwordPattern, password);

        return isValid;
    }

    // check email theo mau
    public boolean emailPattern(String email) {
        boolean isValid = Pattern.matches(emailPattern, email);
        if (isValid == false) {
            System.out.println("Email sai mẫu");
        }
        return isValid;
    }

    // check password duplicate and pattern
    public boolean checkPasswordTochangePass(String password, User user) {
        boolean isDuplicate = false;
        boolean isValid = passwordPattern(password);
        if (User.checkPasswordDuplicate(password, user) == false && isValid == true) {
            isDuplicate = true;
        }
        return isDuplicate;
    }

    // check email duplicate and pattern
    public boolean checkEmailTochangeEmail(String email) {
        boolean isDuplicate = false;
        boolean isValid = emailPattern(email);
        // check pattern
        if (isValid == false) {
            return isDuplicate;
        }
        if (isValid == true && isUserExistence() == true && checkEmail(email) == false) {
            isDuplicate = true;
        } else if (isUserExistence() == false && isValid == true) {
            isDuplicate = true;
        }

        return isDuplicate;
    }

    private static boolean isUserExistence() {
        boolean isUserExistence = false;
        if (USER_COUNT != 0) {
            isUserExistence = true;
        }
        return isUserExistence;
    }

    public static boolean changeUserName(String userName) {
        boolean isNewUserNameValid = checkUserName(userName);
        if (isNewUserNameValid == true) {
            System.out.println("đã tồn tại userName này");
            finishLine();
        } else {
            user.setUserName(userName);
            System.out.println("Thay đổi username thành công");
            System.out.println("Username của bạn là: " + user.userName);
        }
        return !(isNewUserNameValid);
    }

    // change email
    public static boolean changeEmail(String email) {
        boolean isNewEmailValid = user.checkEmailTochangeEmail(email);
        if (isNewEmailValid == false) {
            System.out.println("email không phù hợp");
            finishLine();
        } else {
            user.setEmail(email);
            System.out.println("Thay đổi email thành công");
            System.out.println("Email mới của bạn là: " + user.email);
        }
        return (isNewEmailValid);
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public static boolean changePassword(String password) {
        boolean isNewPasswordValid = user.checkPasswordTochangePass(password, user);
        if (isNewPasswordValid == false) {
            System.out.println("password bị trùng");
            finishLine();
        } else {
            user.setUserName(password);
            System.out.println("Thay đổi password thành công");
        }
        return (isNewPasswordValid);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static User getUser() {
        return user;
    }

    public List<User> getUserList() {
        return userList;
    }

}
