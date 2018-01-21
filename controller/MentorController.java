package queststore.controller;

import queststore.view.MentorView;
import queststore.model.StudentModel;
import queststore.model.WalletModel;
import queststore.model.GroupModel;

public class MentorController {

    private MentorView view;
    private InputController inputController;

    public MentorController() {
        view = new MentorView();
        inputController = new InputController();
    }
    public GroupModel selectGroup() { //HARDCODED
        return new GroupModel("A");
    }
    public void createStudent() {
        String studentName = inputController.getStringInput("Enter student name: ");
        String studentLastName = inputController.getStringInput("Enter student last name: ");
        String studentEmail = inputController.getStringInput("Enter student email: ");
        String studentPassword = inputController.getStringInput("Enter student password: ");
        GroupModel group = selectGroup();
        WalletModel wallet = new WalletModel();
        StudentModel newStudent = new StudentModel(studentName, studentLastName, studentEmail, studentPassword, group, wallet);
    }

}