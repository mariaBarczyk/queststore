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
        StudentModel student1 = new StudentModel(1, "Kasia", "Drobna", "kasia@gmail.com", "kitka");
        StudentModel student2 = new StudentModel(2, "Marysia", "Barszczyk", "maria@gmail.com", "kawa");
        StudentModel student3 = new StudentModel(3, "Justyna", "Fornalik", "justi@gmail.com", "herbata");
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
