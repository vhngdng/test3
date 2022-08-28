package Controller;


// public class UserController {
//     private User user;
//     public final String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
//     public final String passwordPattern = "^(?=.*?[A-Z])(?=.*?[.,-_;]).{7,15}$";

//     // check Username bi trung
//     public boolean checkUserName(String userName) {
//         boolean isDuplicate = user.checkUserName(userName);
//         return isDuplicate;
//     }

//     public boolean checkPassword(String password) {
//         boolean isDuplicate = user.checkPassword(password);
//         return isDuplicate;
//     }
//     // Check Password bi trung
//     public boolean checkPasswordTochangePass(String password) {
//         boolean isDuplicate = false;
//         boolean isValid = passwordPattern(password);
//         if (user.checkPassword(password) == false && isValid == true) {

//             isDuplicate = true;
//         }
//         return isDuplicate;
//     }

//     //check email to login
//     public boolean checkEmail(String email) {
//         boolean isDuplicate = user.checkEmail(email);
//         return isDuplicate;
//     }

//     // Check email bi trung
//     public boolean checkEmailTochangeEmail(String email) {
//         boolean isDuplicate = false;
//         boolean isValid = emailPattern(email);
//         if (user.checkEmail(email) == false && isValid == true) {

//             isDuplicate = true;
//         }
//         return isDuplicate;
//     }

//     // Check user co ton tai khong
//     public boolean isUserExistence() {
//         boolean isUserExistence = (user != null);
//         return isUserExistence;
//     }

//     // check password theo mau
//     public boolean passwordPattern(String password) {

//         boolean isValid = Pattern.matches(passwordPattern, password);
//         System.out.println(isValid);
//         return isValid;
//     }

//     // Check email theo mau
//     public boolean emailPattern(String email) {

//         boolean isValid = Pattern.matches(emailPattern, email);
//         return isValid;
//     }

//     public User addUser(User userNew) {
//         user = userNew;
//         user.addUser(user);
//         return user;
//     }
// }
