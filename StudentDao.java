import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public static List<StudentModel> studentsList;

    public StudentDao() {
        this.studentsList = new ArrayList<StudentModel>();
    }

    public List<StudentModel> getStudentsList() {
        return this.studentsList;
    }

    public void addStudent() {
        StudentModel student1 = new StudentModel("Kasia", "Drobna", "kasia@gmail.com", "kitka", "Student");
        StudentModel student2 = new StudentModel("Marysia", "Barszczyk", "maria@gmail.com", "kawa", "Mentor");
        StudentModel student3 = new StudentModel("Justyna", "Fornalik", "justi@gmail.com", "herbata", "Admin");
        this.studentsList.add(student1);
        this.studentsList.add(student2);
        this.studentsList.add(student3);
    }

    

}
