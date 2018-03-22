package model;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class StudentModelTest {

    @Mock
    private WalletModel walletModel = Mockito.mock(WalletModel.class);
    private GroupModel groupModel = Mockito.mock(GroupModel.class);

    @Test
    public void checkIfStudentModelHasWallet(){
        StudentModel studentModel = new StudentModel(1, "Adam", "Kruk", "adam@gmal.com",
                                                "lala", groupModel, walletModel);
        assertEquals(walletModel, studentModel.getMyWallet());
    }

    @Test
    public void checkIfStudentModelHasGroup(){
        StudentModel studentModel = new StudentModel(1, "Adam", "Kruk", "adam@gmal.com",
                "lala", groupModel, walletModel);
        assertEquals(groupModel, studentModel.getGroup());
    }
}