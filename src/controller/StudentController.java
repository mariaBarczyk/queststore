package controller;

import java.util.List;

import queststore.controller.InputController;
import queststore.model.ItemModel;
import queststore.view.StudentView;

public class StudentController {

    private StudentView view;
    private InputController inputController;

    public StudentController() {
        view = new StudentView();
        inputController = new InputController();
    }
    private void displayAvailableArtifacts() {
         List<ItemModel>  artifactCollection = ItemModel.getCollectionByType("Artifact");
         view.displayCollectionOfItem(artifactCollection);
    }
    public void buyArtifact() {

    }
}