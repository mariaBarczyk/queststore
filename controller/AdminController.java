package queststore.controller;

import java.util.List;
import queststore.controller.InputController;
import queststore.view.AdminView;
import queststore.model.MentorModel;
import queststore.model.GroupModel;


public class AdminController {

    private AdminView view;
    private InputController inputController;

    public AdminController() {
        view = new AdminView();
        inputController = new InputController();
    }

    public void controlMenuOptions() {
        boolean exit = false;
        while (!exit) {
            view.displayAdminMenu();
            int userChoice = inputController.getIntInput("SELECT AN OPTION: ");
            switch (userChoice) {
                case 1:
                    createMentor();
                    break;
                case 2:
                    createGroup();
                    break;
                case 3:
                    editMentorData();
                    break;
                case 4:
                    displayMentorData();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong number!");
            }
        }
    }

    public GroupModel selectGroup() {
        // List<GroupModel> allGroups = AdminModel.getGroupList();
        return new GroupModel("A");
    }

    public void createMentor() {
        String mentorName = inputController.getStringInput("Enter mentor name: ");
        String mentorLastName = inputController.getStringInput("Enter mentor last name: ");
        String mentorEmail = inputController.getStringInput("Enter mentor email: ");
        String mentorPassword = inputController.getStringInput("Enter mentor password: ");
        GroupModel mentorGroup = selectGroup();
        MentorModel newMentor = new MentorModel(mentorName, mentorLastName, mentorEmail, mentorPassword, mentorGroup);
    }

    public void createGroup() {
        String groupName = inputController.getStringInput("Enter group name: ");
        GroupModel newGroup = new GroupModel(groupName);
    }

    public MentorModel selectMentor() {
        List<MentorModel> allMentors = MentorModel.getMentorsCollection();
        view.displayAllMentors(allMentors);
        String fullName = inputController.getStringInput("Enter mentor full name: ");
        MentorModel matchedMentor = null;
        for (MentorModel mentor: allMentors)
            if (mentor.getFullName().equals(fullName)) 
                matchedMentor = mentor;
        return matchedMentor;
    }

    public void editMentorData() {
        MentorModel mentorToEdit = selectMentor();        
        boolean exit = false;
        while (!exit) {
            view.displayEditMentorMenu();
            int userChoice = inputController.getIntInput(" ");
            switch(userChoice) {
                case 1:
                    mentorToEdit.setName(inputController.getStringInput("Enter mentor name:"));
                    break;
                case 2:
                    mentorToEdit.setLastName(inputController.getStringInput("Enter mentor last name"));
                    break;
                case 3:
                    mentorToEdit.setEmail(inputController.getStringInput("Enter mentor email"));
                    break;
                case 4:
                    mentorToEdit.setLastName(inputController.getStringInput("Enter mentor password"));
                    break;
                case 5:
                    GroupModel group = selectGroup();
                    mentorToEdit.setGroup(group);
                    break;
                default:
                    exit = true;
                    break;
            }
        }
    }

    public void displayMentorData() {
        MentorModel mentor = selectMentor();
        view.displayMentorData(mentor);
    }

}