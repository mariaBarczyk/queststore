package controller;

import dao.StudentDao;

public class RootController {

    private UserController userController;
//    private AdminController adminController;

    public RootController() {
        userController = new UserController();
//        adminController = new AdminController();
    }

    public static void main(String[] args) {
        RootController controller = new RootController();
        controller.userController.startApplication();

    }
}

