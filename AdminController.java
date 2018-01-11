public class AdminController {

    AdminView view = new AdminView();

    public void createNewMentor() {
        newMentorData = view.getMentorData();
        StudentDao studDao = new StudentDao();
        studDao.createStudent(newMentorData);
    }
    public void initializeNewClass() {
        String name = view.getUserInput("Enter class name: ");
    }
    // public static void main(String[] args) {
    //     AdminController adminC = new AdminController();
    //     System.out.println(adminC.newMentorData[0]);    
    // }
}