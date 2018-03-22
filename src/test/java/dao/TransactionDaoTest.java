package dao;

import model.ItemModel;
import model.StudentModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class TransactionDaoTest extends TestableDatabaseUnit{

    @Test
    void testUpdateStatusOfTransaction() {
        ItemModel mockItem =  Mockito.mock(ItemModel.class);
        Mockito.when(mockItem.getID()).thenReturn(1);
        TransactionDao td = new TransactionDao();
        td.updateStatusOfTransaction(mockItem);

        String query = "SELECT count(*) as rows_count FROM Transactions WHERE id_item = 1;";
        ResultSet rs = td.executeSelect(query);
        try {
            int i = rs.getInt("rows_count");
            assertEquals(4, i);
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }


}