package controller;

import view.UserView;
import model.UserModel;
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
        QueststoreDao dao = new QueststoreDao("user_data.txt");
//        UserModel user = userDao.checkIfUserExist(login, password);
//        return user;
    }
}
