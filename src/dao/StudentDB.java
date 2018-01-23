package dao;

import java.sql.*;

public class StudentDB{

    public void insertNewStudent(String studentName, String studentLastName, String studentEmail, String studentPassword, int id_group, int id_wallet) {
        //QueststoreDao dao = new Queststore();
        String table = "Student";
        int idStatus = 3;
        String columns = "(first_name, last_name, email, password, id_status, id_group, id_wallet)";
        String values = "'" + studentName + "', '" + studentLastName + "', '" + studentEmail + "','" + studentPassword + "', " + idStatus + ", " + id_group + ", " + id_wallet + "";
        //dao.insertDataIntoTable(table, columns, values);
    }
}