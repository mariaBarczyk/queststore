import java.util.Scanner;

public class AdminController {

    AdminView view = new AdminView();

    /*public void createNewMentor() {
        String[] newMentorData = view.getMentorData();
        MentorDao mentDao = new StudentDao();
        studDao.createStudent(newMentorData);
    }*/
    public void initializeNewClass() {
        String name = view.getUserInput("Enter class name: ");
    }

    public static void createNewMentor() {
          
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type the first name of the Mentor: ");
        String firstName = scanner.next();

        System.out.println("Please type the last name of the Mentor: ");
        String lastName = scanner.next();

        System.out.println("Please type the email of the Mentor: ");
        String email = scanner.next();

        System.out.println("Please type the password of the Mentor: ");
        String password = scanner.next();

        System.out.println("Please type the status (Mentor): ");
        String status = scanner.next();

        //System.out.println("Please type the name of class which Mentor will be belong: ");
        //String group = scanner.next();
        
        MentorModel mentor = new MentorModel(firstName, lastName, email, password); // add class
        System.out.println("The following Mentor created: " + mentor);

    }

}
