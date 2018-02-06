package controller;

import dao.ItemDao;
import dao.StudentDao;
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
//                    markQuest();
                    break;  
                case 7:
                    // Mark student's bought artifacts\n"
                    break;    
                case 8:
//                    displayStudentWallet();
                    break;                                                            
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong number!");
            }
        }
    }

    private GroupModel selectGroup() { //HARDCODED
        return new GroupModel("A");
    }

    private void createStudent() {
        String studentName = inputController.getStringInput("Enter student name: ");
        String studentLastName = inputController.getStringInput("Enter student last name: ");
        String studentEmail = inputController.getStringInput("Enter student email: ");
        String studentPassword = inputController.getStringInput("Enter student password: ");
        StudentDao studentDao = new StudentDao();
        studentDao.insertNewStudent(studentName, studentLastName, studentEmail, studentPassword);
        //GroupModel group = selectGroup();
        //WalletModel wallet = new WalletModel();
        //StudentModel newStudent = new StudentModel(studentName, studentLastName, studentEmail, studentPassword, group, wallet);
    }

    private void createQuest() {
        String questName = inputController.getStringInput("Enter quest name: ");
        String questDescription = inputController.getStringInput("Enter quest description: ");
        int questValue = inputController.getIntInput("Enter quest value: ");
        QuestModel newQuest = new QuestModel("Quest", questName, questDescription, questValue);
        ItemDao itemDao = new ItemDao();
        itemDao.insertNewItem(newQuest);
    }

    private void createArtifact() {
        String artifactName = inputController.getStringInput("Enter artifact name: ");
        String artifactDescription = inputController.getStringInput("Enter artifact description: ");
        int artifactValue = inputController.getIntInput("Enter artifact value: ");
        ArtifactModel newArtifact = new ArtifactModel("Artifact", artifactName, artifactDescription, artifactValue);
        ItemDao itemDao = new ItemDao();
        itemDao.insertNewItem(newArtifact);
    }

    private ItemModel selectItem(String type) {
        ItemDao itemDao = new ItemDao();
        List<ItemModel> itemCollection = itemDao.getItemCollectionByType(type);
        view.displayItemCollection(itemCollection);
        int id = inputController.getIntInput("Enter id of item: ");
        ItemModel matchedItem = null;
        for (ItemModel item: itemCollection)
            if (item.getID() == id)
                matchedItem = item;
        return matchedItem;
    }


//    private void changePriceOfItem(String type) {
//        ItemModel item = selectItem(type);
//        int newPrice = inputController.getIntInput("Enter new price: ");
//        item.setValue(newPrice);
//    }
    private void changePriceOfItem(String type) {
        ItemModel item = selectItem(type);
        int newPrice = inputController.getIntInput("Enter new price: ");
        item.setValue(newPrice);
        ItemDao itemDao = new ItemDao();
        itemDao.updateValueOfItem(item);
    }

    private StudentModel selectStudent() {
        List<StudentModel> allStudents = StudentModel.getStudentsCollection();
        view.displayAllStudents(allStudents);
        String fullName = inputController.getStringInput("Enter student full name: ");
        StudentModel matchedStudent = null;
        for (StudentModel student: allStudents)
            if (student.getFullName().equals(fullName))
                matchedStudent = student;
        return matchedStudent;
    }
//    private void displayStudentWallet() {
//        StudentModel student = selectStudent();
//        WalletModel wallet = student.getWallet();
//        view.displayStudentWallet(wallet);
//    }
//    private void markQuest() {
//        StudentModel selectedStudent = selectStudent();
//        ItemModel selectedQuest = selectItem("Quest");
//        selectedStudent.setValuesInWallet(select edQuest.getValue());
//    }

    private ArtifactModel selectArtifactToMark(){
        StudentModel selectedStudent = selectStudent();
        int selectedStudentId = selectedStudent.getID();
        ItemDao itemDao = new ItemDao();
        int id_type = itemDao.findIdType("Artifact");
        return ArtifactModel selectedArtifact = itemDao.selectItem(selectedStudentId);

    }
}