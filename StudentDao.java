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
        StudentModel student1 = new StudentModel("Kasia", "Drobna", "kasia@gmail.com", "kitka", "Student");
        StudentModel student2 = new StudentModel("Marysia", "Barszczyk", "maria@gmail.com", "kawa", "Student");
        StudentModel student3 = new StudentModel("Justyna", "Fornalik", "justi@gmail.com", "herbata", "Student");
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
