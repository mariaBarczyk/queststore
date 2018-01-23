package controller;

import queststore.view.UserView;
//import queststore.view.UserModel;


public class UserController {

    public UserController() {
        UserView view = new UserView();
        InputController inputController = new InputController();
    }
    public void logIn() {
        String login = inputController.getStringInput("Enter login: ");
        String password = inputController.getStringInput("Enter password: ");
//        UserDao userDao = new UserDao("user_data.txt");
//        UserModel user = userDao.checkIfUserExist(login, password);
//        return user;
    }
    public static void main() {

    }
}
