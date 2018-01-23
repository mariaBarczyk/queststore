package controller;

import view.UserView;
import dao.QueststoreDao;


public class UserController {

    private InputController inputController = new InputController();

    public UserController() {
        UserView view = new UserView();
        inputController = new InputController();
    }
    public void logIn() {
        String login = inputController.getStringInput("Enter login: ");
        String password = inputController.getStringInput("Enter password: ");
        QueststoreDao dao = new QueststoreDao();
        dao.checkIfUserExist(login,password);
        dao.getAllDataFromTable("Login");
        return user;
    }
}
