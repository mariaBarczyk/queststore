package dao;

import java.sql.*;

public class StudentDao{

    public void insertNewWallet(){
        QueststoreDao dao = new QueststoreDao();
        String tableName = "Wallet";
        String columns = "(totalCoolcoins, balance, id_artifact)";
        String values = (0 +", "+ 0 +", " + null);
        dao.insertDataIntoTable(tableName, columns, values);


    }

    public void insertNewStudent(String studentName, String studentLastName, String studentEmail, String studentPassword, int id_group) {
        QueststoreDao dao = new QueststoreDao();
        insertNewWallet();
        int idWallet = dao.getMaxValueInTable("Wallet", "id_wallet");
        String table = "Student";
        int idStatus = 3;
        String columns = "(first_name, last_name, email, password, id_status, id_group, id_wallet)";
        String values = "'" + studentName + "', '" + studentLastName + "', '" + studentEmail + "','" + studentPassword + "', " + idStatus + ", " + id_group + ", " + idWallet + "";
        dao.insertDataIntoTable(table, columns, values);
    }
}