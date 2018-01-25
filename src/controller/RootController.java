package controller;

public class RootController {

    UserController userController;
    AdminController adminController;

    public RootController() {
        userController = new UserController();
        adminController = new AdminController();

    }
    public static void main(String[] args) {
        RootController controller = new RootController();
        String userStatus = controller.userController.logIn();
        switch (userStatus) {
            case "Admin":
                AdminController adminController = new AdminController();
                adminController.controlMenuOptions();
                break;
            case "Mentor":
                MentorController mentorController = new MentorController();
                mentorController.controlMenuOptions();
                break;
            case "Student":
                StudentController studentController = new StudentController();
                studentController.controlMenuOptions();
                break;
        }
    }
}

