package dao;

import model.StudentModel;
import model.UserModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StudentDaoTest extends TestableDatabaseUnit{

    private StudentDao studentDao = new StudentDao();


    @Mock
    private UserModel student = Mockito.mock(StudentModel.class);


    @Test
    void getStudentByLoginIdReturnsGoodIdTest(){
        Mockito.when(student.getID()).thenReturn(1);
        assertEquals(student.getID(), studentDao.getStudentByIdLogin(4).getID());
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