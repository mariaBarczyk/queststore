import java.util.Scanner;

public class UserView {

    public void displayWelcomeMessage () {
        System.out.println("Welcome to the Codecool Queststore!");
    }
    public String getLogin (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String login = scanner.nextLine();
        return login;
    }
    public String getPassword () {
        System.out.println("Enter your password: ");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        return password;
    }
    public static void main(String[] args) {
        UserView user = new UserView();
        user.displayWelcomeMessage();
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());
    }
}
