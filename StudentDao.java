import java.util.ArrayList;
import java.util.List;

public class StudentDao implements StudentDaoInterface {
    private List<StudentModel> studentsList;

    public StudentDao() {
        this.studentsList = new ArrayList<StudentModel>();
    }
    public List<StudentModel> getStudentsList() {
        return this.studentsList;
    }
    public void addStudent() {
        WalletModel newWallet = new WalletModel();
        ClassModel newClass = new ClassModel();
        StudentModel student1 = new StudentModel("Kasia", "Drobna", "kasia@gmail.com", "kitka", "Student", newClass, newWallet);
        StudentModel student2 = new StudentModel("Marysia", "Barszczyk", "maria@gmail.com", "kawa", "Student", newClass, newWallet);
        StudentModel student3 = new StudentModel("Justyna", "Fornalik", "justi@gmail.com", "herbata", "Student", newClass, newWallet);
        this.studentsList.add(student1);
        this.studentsList.add(student2);
        this.studentsList.add(student3);
    }
    public void getStudentsByClass(){

    }
    public void getStudent() {

    }
    public void createStudent() {
    }

    

}
