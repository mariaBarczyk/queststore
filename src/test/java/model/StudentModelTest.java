package model;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class StudentModelTest {

    @Mock
    private WalletModel walletModel = Mockito.mock(WalletModel.class);

    @Test
    public void checkIfStudentModelHasWallet(){
        StudentModel studentModel = new StudentModel(1, "Adam", "Kruk", "adam@gmal.com",
                                                "lala", "2016.2", walletModel);
        assertEquals(walletModel, studentModel.getMyWallet());
    }
}