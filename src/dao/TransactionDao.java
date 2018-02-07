package dao;

import model.ItemModel;


public class TransactionDao extends UserDao {

    public void insertTransaction(int idStudent, int idItem) {
        String values =  "("+ idStudent +", " + idItem+ "," + 0 + ")";
        insertDataIntoTable("Transactions ", "(id_student, id_item, used)", values);
    }

    public void updateStatusOfTransaction(ItemModel item) {
        int itemId = item.getID();
        updateDataInTable("Transactions", "used = 1", "id_item="+itemId);
    }



}
