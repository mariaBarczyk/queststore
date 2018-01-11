import java.util.List;

public interface StudentDaoInterface {
    public List<StudentModel> getStudentsList();
    public void getStudentsByClass();
    public void getStudent();
    public void createStudent();
}