package controller;

import view.UserView;
import model.UserModel;


public class UserController {
    InputController inputController = new InputController();

    public UserController() {
        UserView view = new UserView();


    }

    public void logIn() {
        String login = inputController.getStringInput("Enter login: ");
        String password = inputController.getStringInput("Enter password: ");
//        UserDao userDao = new UserDao("user_data.txt");
//        UserModel user = userDao.checkIfUserExist(login, password);
//        return user;
    }
}
