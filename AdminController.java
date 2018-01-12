import java.util.Scanner;
import java.util.List;

public class AdminController {

    AdminView view = new AdminView();

    public void createNewMentor() {
        String[] newMentorData = view.getMentorData();
        ClassDao classDao = new ClassDao();
        String className = view.getClassName();
        ClassModel newClass = classDao.createClass(className);
        MentorDao mentorDao = new MentorDao();
        mentorDao.createMentor(newMentorData, newClass);
    }
    public void initializeNewClass() {
        String name = view.getClassName();
        ClassDao classDao = new ClassDao();
        classDao.createClass(name);
    }
    public void getMentorData() {
        MentorDao mentorDao = new MentorDao();
        List<MentorModel> mentorList = mentorDao.getMentorsList();
        view.displayMentors(mentorList);
        Integer mentorId = view.getMentorId();
        if (mentorId != null) {
            MentorModel mentor = mentorDao.getMentor(mentorId);
            view.displayMentorData(mentor);
        }
    }
    public void start() {
        boolean exit = false;
        while (!exit) {
            AdminView.displayAdminMenu();
            String userChoice = view.getUserInput("Select an option: ");   
            switch (userChoice) {
                case "1":
                    createNewMentor();
                    break;
                case "2":
                    initializeNewClass();
                    break;
                case "3":
                    System.out.println("Edit mentor");
                    break;
                case "4":
                    System.out.println("Display mentor data");
                    getMentorData();
                    break;
                default:
                    System.out.println("Wrong number!");
            }
        }
    }
}
