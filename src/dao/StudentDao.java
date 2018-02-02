package dao;

import model.StudentModel;
import model.WalletModel;

import java.sql.*;

public class StudentDao extends QueststoreDao{

    public void insertNewWallet(int idLogin){

        String condition ="id_login = "+idLogin;
        int idStudent = 0;
        ResultSet idStudentResult = selectDataFromTable("Student","id_student", condition);
        try{
            idStudent = idStudentResult.getInt("id_student");
        } catch (Exception e) {
        }

        String tableName = "Wallet";
        String columns = "(total_coolcoins, balance, id_student)";
        String values = "("+0 +", "+ 0 +", " + idStudent + ")";
        insertDataIntoTable(tableName, columns, values);


    }

    /*public void insertNewStudent(String studentName, String studentLastName, String studentEmail, String studentPassword, int id_group) {
        QueststoreDao dao = new QueststoreDao();
        insertNewWallet();
        int idWallet = dao.getMaxValueInTable("Wallet", "id_wallet");
        String table = "Student";
        int idStatus = 3;
        String columns = "(first_name, last_name, id_login, id_status, id_group)";
        String values = "'" + studentName + "', '" + studentLastName + "', '" + studentEmail + "','" + studentPassword + "', " + idStatus + ", " + id_group + ", " + idWallet + "";
        dao.insertDataIntoTable(table, columns, values);
    }*/

    public void insertNewStudent(String studentName, String studentLastName, String studentEmail, String studentPassword) {
        String loginTable = "Login";
        int idStatus = 3;
        String loginColumns = "(email, password, id_status)";
        String loginValues = "('"+studentEmail+"', '"+ studentPassword + "', " + idStatus + ");";
        insertDataIntoTable(loginTable, loginColumns, loginValues);

        String condition = "email = '" + studentEmail + "' AND password = '"+studentPassword+"'";
        int idLogin = 0;
        ResultSet idLoginResult = selectDataFromTable("Login","id_login", condition);
        try{
            idLogin = idLoginResult.getInt("id_login");
        } catch (Exception e) {
        }

        int id_group = 1;
        String table = "Student";
        String columns = "(first_name, last_name, id_login, id_status, id_group)";
        String values = "('" + studentName + "', '" + studentLastName + "', " + idLogin +", "+ idStatus + ", " + id_group + ");";
        insertDataIntoTable(table, columns, values);
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