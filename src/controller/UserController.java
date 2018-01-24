package controller;

import view.UserView;
import dao.QueststoreDao;


public class UserController {

    private UserView view;
    private InputController inputController = new InputController();

    public UserController() {
        view = new UserView();
        inputController = new InputController();
    }
    public String logIn() {
        String login = inputController.getStringInput("Enter login: ");
        String password = inputController.getStringInput("Enter password: ");
        QueststoreDao dao = new QueststoreDao();
        return  dao.findStatus(login, password);
    }
}

