package controller;

import java.util.List;

import model.ItemModel;
import view.StudentView;
import model.StudentModel;


public class StudentController {

    private StudentView view;
    private InputController inputController;

    public StudentController() {
        view = new StudentView();
        inputController = new InputController();
    }

    public void controlMenuOptions() {
        boolean exit = false;
        while (!exit) {
            view.displayStudentMenu();
            int userChoice = inputController.getIntInput("SELECT AN OPTION: ");
            switch (userChoice) {
                case 1:
                    //view.displayWallet();
                    break;
                case 2:
                    //buyArtifact(student);
                    break;
                case 3:
                    //Buy artifact together with teammates;
                    break;
                case 4:
                    //4 - See your level of experience\n";
                    break;                                                         
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong number!");
            }
        }
    }
      
    private void displayAvailableArtifacts() {
         List<ItemModel>  artifactCollection = ItemModel.getCollectionByType("Artifact");
         view.displayCollectionOfItem(artifactCollection);
    }
    public void buyArtifact(StudentModel student) {
        displayAvailableArtifacts();
        String artifactName = inputController.getStringInput("Enter artifact name to buy: ");
        List<ItemModel> availableArtifacts = ItemModel.getCollectionByType("Artifact");
        for (ItemModel artifact: availableArtifacts)
            if(artifact.getName().equals(artifactName))
                student.setValuesInWallet(artifact.getValue());
    }
}