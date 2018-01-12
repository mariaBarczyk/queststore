//import java.util.Scanner;

public class Application {

    public static void main(String[] args){
        System.out.println("Welcome please enter your login and password"); 

        UserDao udao = new UserDao("user_data.txt");
        System.out.println("***** Users List******");
        System.out.println(udao.toString());
        AdminDao adao = new AdminDao();
        adao.addAdmin();
        System.out.println(adao.getAdminsList());
        UserController controller = new UserController();
        UserModel user = controller.logIn(); 
        controller.start(user);  
        
    }
}