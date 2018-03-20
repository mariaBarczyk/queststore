package dao;

import model.StudentModel;

import java.sql.ResultSet;
import java.util.List;

public interface StudentDaoInterface {

    StudentModel getStudentByIdLogin(int idLogin);

    StudentModel createStudentObject(ResultSet result);

    List<StudentModel> getStudentsCollection();

    void insertNewStudent(StudentModel student);

    void updateWallet(StudentModel student);
}

