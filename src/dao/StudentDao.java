package dao;

import model.StudentModel;
import model.WalletModel;

import java.sql.*;

public class StudentDao extends UserDao{

    private void insertNewWallet(int idLogin){
        UserDao newDao = new UserDao();
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
        UserDao newDao = new UserDao();
        int id_group = 1;
        String table = "Student";
        String columns = "(first_name, last_name, id_login, id_status, id_group)";
        String values = "('" + studentName + "', '" + studentLastName + "', " + idLogin +", "+ idStatus + ", " + id_group + ");";
        newDao.insertDataIntoTable(table, columns, values);
        insertNewWallet(idLogin);
    }

    private WalletModel getStudentWallet(int idWallet) {
        ResultSet result = selectDataFromTable("Wallet","totalCoolcoins, balance", "id_wallet='"+idWallet+"'");
        WalletModel wallet = null;
        try {
            while (result.next()) {
                int totalCoins = result.getInt("totalCoolcoins");
                int balance = result.getInt("balance");
                wallet = new WalletModel(idWallet, totalCoins, balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wallet;
    }

    public StudentModel selectStudent(int idLogin) {
        String columns = "Login.email, Login.password, id_student, first_name, last_name, id_wallet";
        String joinStatement = "Login.id_login=Student.id_login";
        // CREATE NEW SELET JOIN WITH WHERE (idLogin ==)
        ResultSet result = selectFromJoinedTables(columns, "Student", "Login", joinStatement);
        StudentModel student = null;
        try {
            while (result.next()) {
                String email = result.getString("email");
                String password = result.getString("password");
                int id = result.getInt("id_student");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                int idWallet = result.getInt("id_wallet");
                WalletModel wallet = getStudentWallet(idWallet);
                student = new StudentModel(id, firstName, lastName, email, password, wallet);
            }
        }catch (SQLException e) {
                e.printStackTrace();
        }
        return student;
    }
}