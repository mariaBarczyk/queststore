package dao;

import model.StudentModel;
import model.UserModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StudentDaoTest {

    private StudentDao studentDao = new StudentDao();


    @Mock
    private UserModel student = Mockito.mock(StudentModel.class);


    @Test
    void checkIfIdReturnValueTest(){
        Mockito.when(student.getID()).thenReturn(1);

    }

    @Test
    void getStudentById() {
    }

    @Test
    void getStudentsCollection() {
    }

    @Test
    void insertNewStudent() {
    }

    @Test
    void updateWallet() {
    }
}