package queststore.controller;

import queststore.controller.InputController;
import queststore.view.StudentView;

public class StudentController {

    private StudentView view;
    private InputController inputController;

    public StudentController() {
        view = new StudentView();
        inputController = new InputController();
    }
}