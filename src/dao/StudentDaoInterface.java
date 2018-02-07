package dao;

import model.StudentModel;

public interface StudentDaoInterface {
    void insertNewStudent(String studentName, String studentLastName, String studentEmail, String studentPassword);
//    StudentModel selectStudent(int idLogin);
}
