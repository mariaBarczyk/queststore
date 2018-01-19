package queststore-kryptonimjava.controller;

public class UserController {

    UserView view;

    public UserController() {
        this.view = new UserView();
    }
    public UserModel logIn() {
        String login = view.getLogin();
        String password = view.getPassword();
        UserDao userDao = new UserDao("user_data.txt");
        UserModel user = userDao.checkIfUserExist(login, password);
        return user;
    }
    public void start(UserModel user) {
        if (user.getStatus().equals("Student")) {
            StudentView.displayStudentMenu();
        } else if (user.getStatus().equals("Mentor")) {
            MentorView.displayMentorMenu();
        } else if (user.getStatus().equals("Admin")) {
            AdminController adminController = new AdminController();
            adminController.start();
        }
    } 
}