//import java.util.Scanner;

public class Application {

    public static void main(String[] args){
        System.out.println("Welcome please enter your login and password"); 
        System.out.println("***** Students List*****\n");
        StudentDao sdao = new StudentDao(); 
        sdao.addStudent();
        System.out.println(sdao.getStudentsList().toString());

        System.out.println("***** Mentors List*****\n");
        MentorDao mdao = new MentorDao();
        mdao.addMentor();
        System.out.println(mdao.getMentorsList());
        System.out.println("***** Users List*****\n");
        UserDao udao = new UserDao("user_data.txt");
        System.out.println(udao.getUsersList());
        System.out.println("***** Users List ----- STRING*****");
        System.out.println(udao.toString());
        //System.out.println(udao.checkIfUserExist());
        AdminDao adao = new AdminDao();
        adao.addAdmin();
        System.out.println(adao.getAdminsList());
        UserView view = new UserView();
        String login = view.getLogin();
        String password = view.getPassword();
        System.out.println(udao.checkIfUserExist(login, password));
        //System.out.println(login);
    }
}