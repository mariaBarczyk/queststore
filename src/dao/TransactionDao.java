package dao;

public class TransactionDao extends QueststoreDao {

    public void insertTransaction(int idStudent, int idItem) {
        String values =  "("+ idStudent +", " + idItem+ "," + 0 + ")";
        insertDataIntoTable("Transactions ", "(id_student, id_item, used)", values);

    }
}
