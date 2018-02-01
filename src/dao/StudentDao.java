package dao;

import java.sql.*;

public class StudentDao extends QueststoreDao{

    private void insertNewWallet(int idLogin){
        QueststoreDao newDao = new QueststoreDao();
        String condition ="id_login = "+idLogin;
        int idStudent = 0;
        ResultSet idStudentResult = newDao.selectDataFromTable("Student","id_student", condition);
        try{
            idStudent = idStudentResult.getInt("id_student");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String tableName = "Wallet";
        String columns = "(total_coolcoins, balance, id_student)";
        String values = "("+0 +", "+ 0 +", " + idStudent + ")";
        newDao.insertDataIntoTable(tableName, columns, values);
    }

    public void insertNewStudent(String studentName, String studentLastName, String studentEmail, String studentPassword) {
        int idStatus = findStatusIdByName("Student");
        insertNewLogin(studentEmail, studentPassword, idStatus);
        int idLogin = findLoginId(studentEmail, studentPassword);
        QueststoreDao newDao = new QueststoreDao();
        int id_group = 1;
        String table = "Student";
        String columns = "(first_name, last_name, id_login, id_status, id_group)";
        String values = "('" + studentName + "', '" + studentLastName + "', " + idLogin +", "+ idStatus + ", " + id_group + ");";
        newDao.insertDataIntoTable(table, columns, values);
        insertNewWallet(idLogin);
    }
}