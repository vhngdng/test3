import View.LoginView;
import View.View;

public class Main{
    public static void main(String[] args) {
        View view = new View();
        view.display();

        
        LoginView loginView = new LoginView();
        loginView.display();
    }
}