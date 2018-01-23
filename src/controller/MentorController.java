package controller;

import view.MentorView;
import model.StudentModel;
import model.WalletModel;
import model.GroupModel;
import model.ItemModel;
import model.QuestModel;
import model.ArtifactModel;

import java.util.List;
import java.util.ArrayList;


public class MentorController {

    private MentorView view;
    private InputController inputController;

    public MentorController() {
        view = new MentorView();
        inputController = new InputController();
    }

    public void controlMenuOptions() {
        boolean exit = false;
        while (!exit) {
            view.displayMentorMenu();
            int userChoice = inputController.getIntInput("SELECT AN OPTION: ");
            switch (userChoice) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    createQuest();
                    break;
                case 3:
                    createArtifact();
                    break;
                case 4:
                    changePriceOfItem("Quest");
                    break;
                case 5:
                    changePriceOfItem("Artifact");
                    break; 
                case 6:
                    markQuest();
                    break;  
                case 7:
                    // Mark student's bought artifacts\n"
                    break;    
                case 8:
                    displayStudentWallet();
                    break;                                                            
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong number!");
            }
        }
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

    public void createQuest() {
        String questName = inputController.getStringInput("Enter quest name: ");
        String questDescription = inputController.getStringInput("Enter quest description: ");
        int questValue = inputController.getIntInput("Enter quest value: ");
        QuestModel newQuest = new QuestModel("Quest", questName, questDescription, questValue);        
    }

    public void createArtifact() {
        String artifactName = inputController.getStringInput("Enter artifact name: ");
        String artifactDescription = inputController.getStringInput("Enter artifact description: ");
        int artifactValue = inputController.getIntInput("Enter artifact value: ");
        ArtifactModel newArtifact = new ArtifactModel("Artifact", artifactName, artifactDescription, artifactValue);        
    }

    private ItemModel selectItem(String type) {
        List<ItemModel> itemCollection = ItemModel.getItemCollection();
        view.displayItemCollection(itemCollection);
        String chosenName = inputController.getStringInput("Enter name of item: ");
        ItemModel matchedItem = null;
        for (ItemModel item: itemCollection) 
            if (item.getType().equals(type) && item.getName().equals(chosenName))
                matchedItem = item;
        return matchedItem;
    }

    public void changePriceOfItem(String type) {
        ItemModel item = selectItem(type);
        int newPrice = inputController.getIntInput("Enter new price: ");
        item.setValue(newPrice);
    }

    public StudentModel selectStudent() {
        List<StudentModel> allStudents = StudentModel.getStudentsCollection();
        view.displayAllStudents(allStudents);
        String fullName = inputController.getStringInput("Enter student full name: ");
        StudentModel matchedStudent = null;
        for (StudentModel student: allStudents)
            if (student.getFullName().equals(fullName)) 
                matchedStudent = student;
        return matchedStudent;
    }
    public void displayStudentWallet() {
        StudentModel student = selectStudent();
        WalletModel wallet = student.getWallet();
        view.displayStudentWallet(wallet);
    }
    public void markQuest() {
        StudentModel selectedStudent = selectStudent();
        ItemModel selectedQuest = selectItem("Quest");
        selectedStudent.setValuesInWallet(selectedQuest.getValue());
    }   
}