package controller;

import dao.ItemDao;
import dao.StudentDao;
import dao.TransactionDao;
import view.MentorView;
import model.StudentModel;
import model.WalletModel;
import model.GroupModel;
import model.ItemModel;
import model.QuestModel;
import model.ArtifactModel;

import java.util.ArrayList;
import java.util.List;


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
                    addValueForQuest();
                    break;
                case 7:
                    markItem();
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

    private StudentModel selectStudent() {
        StudentDao studentDao = new StudentDao();
        List<StudentModel> allStudents = studentDao.getStudentsCollection();
        view.displayAllStudents(allStudents);
        int id = inputController.getIntInput("Enter student id to edit: ");
        StudentModel matchedStudent = null;
        for (StudentModel student: allStudents)
            if (student.getID().equals(id))
                matchedStudent = student;
        return matchedStudent;
    }

    private void changePriceOfItem(String type) {
        ItemModel item = selectItem(type);
        int newPrice = inputController.getIntInput("Enter new price: ");
        item.setValue(newPrice);
        ItemDao itemDao = new ItemDao();
        itemDao.updateValueOfItem(item);
    }

    private ItemModel chooseItemToMark(){
        List<ItemModel> itemCollection = new ArrayList<>();
        StudentModel selectedStudent = selectStudent();
        //int selectedStudentId = selectedStudent.getID();
        int selectedStudentId = 1;
        String typeName = inputController.getStringInput("Please type the name of the item (Artifact or Quest): ");
        if (typeName.equalsIgnoreCase("Artifact")) {
            ItemDao itemDao = new ItemDao();
            int id_type = itemDao.findIdType(typeName);
            itemCollection = itemDao.selectStudentsItems(selectedStudentId, id_type);
            view.displayItemCollection(itemCollection);
        } else if (typeName.equalsIgnoreCase("Quest")) {
            ItemDao itemDao = new ItemDao();
            int id_type = itemDao.findIdType(typeName);
            itemCollection = itemDao.selectStudentsItems(selectedStudentId, id_type);
            view.displayItemCollection(itemCollection);
        }
        int id = inputController.getIntInput("Enter id of item: ");
        ItemModel matchedItem = null;
        for (ItemModel item : itemCollection)
            if (item.getID() == id)
                matchedItem = item;
        return matchedItem;
    }

    private void markItem() {
        ItemModel itemToMark = chooseItemToMark();
        TransactionDao transactionDao = new TransactionDao();
        transactionDao.updateStatusOfTransaction(itemToMark);

    }
  
    private List<ItemModel> getStudentArtifacts(int id) {
        TransactionDao transactionDao = new TransactionDao();
        return transactionDao.getStudentArtifact(id);

    }

    private void displayStudentWallet() {
        StudentModel student = selectStudent();
        List<ItemModel> studentArtifacts = getStudentArtifacts(student.getID());
        view.displayStudentWallet(student.getWallet());
        view.displayStudentArtifacts(studentArtifacts);
    }


    private void addValueForQuest() {
        StudentDao studentDao = new StudentDao();
        List<StudentModel> allStudents = studentDao.getStudentsCollection();
        view.displayAllStudents(allStudents);
        int idStudent = inputController.getIntInput("Enter student id to add value for quest: ");
        List<ItemModel> itemCollection = new ArrayList<>();
        StudentModel selectedStudent = selectStudent();
        //int selectedStudentId = 1;
        String typeName = "Quest";
        ItemDao itemDao = new ItemDao();
        int id_type = itemDao.findIdType(typeName);
        itemCollection = itemDao.selectStudentsItems(selectedStudent.getID(), id_type);
        view.displayItemCollection(itemCollection);
        int id = inputController.getIntInput("Enter id of quest: ");
        int value = 0;
        for (ItemModel item : itemCollection) {
            if (item.getID() == id){
                System.out.println(itemCollection.get(id).getValue());
                value = item.getValue();
            }
        }
        selectedStudent.updateAcountBalance(value);
        studentDao.updateWallet(selectedStudent);

        //System.out.println(selectedStudent.getWallet().getBalance());



            //return selectItem().getValue()
    }
}