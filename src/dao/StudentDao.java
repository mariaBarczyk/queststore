package dao;

import model.StudentModel;
import model.WalletModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao extends UserDao{

    private void insertNewWallet(int idLogin){
        String condition ="id_login = "+idLogin;
        int idStudent = 0;
        ResultSet idStudentResult = selectDataFromTable("Student","id_student", condition);
        try{
            idStudent = idStudentResult.getInt("id_student");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String tableName = "Wallet";
        String columns = "(total_coolcoins, balance, id_student)";
        String values = "("+0 +", "+ 0 +", " + idStudent + ")";
        insertDataIntoTable(tableName, columns, values);
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

    private WalletModel getStudentWallet(int idStudent) {
        ResultSet result = selectDataFromTable("Wallet","id_wallet, total_coolcoins, balance", "id_student='"+idStudent+"'");
        WalletModel wallet = null;
        try {
            while (result.next()) {
                int idWallet = result.getInt("id_wallet");
                int totalCoins = result.getInt("total_coolcoins");
                int balance = result.getInt("balance");
                wallet = new WalletModel(idWallet, totalCoins, balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wallet;
    }

    public String prepareGetAllStudentsSql() {
        String columns = "Login.email, Login.password, Student.id_student, first_name, last_name, id_wallet, total_coolcoins, balance";
        String joinStmt1 = "Login.id_login=Student.id_login";
        String joinStmt2 = "Wallet.id_student=Student.id_student";

        String sql = "SELECT " + columns + " FROM Student " +
                " JOIN Login  ON " + joinStmt1 +
                " JOIN Wallet  ON " + joinStmt2;
        return sql;
    }

    public ResultSet createStudentsResult() {
            String sql = prepareGetAllStudentsSql();
            ResultSet result = null;
            try {
                Statement statement = connection.createStatement();
                result = statement.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        }

    public List<StudentModel> getStudentsCollection() {
        ResultSet result =  createStudentsResult();
        List<StudentModel> studentCollection = new ArrayList<>();
        try {
            while (result.next()) {
                String email = result.getString("email");
                String password = result.getString("password");
                int id = result.getInt("id_student");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                int idWallet = result.getInt("id_wallet");
                int totalCoolcoins = result.getInt("total_coolcoins");
                int balance = result.getInt("balance");
                WalletModel wallet = new WalletModel(idWallet, totalCoolcoins, balance);
                StudentModel student = new StudentModel(id, firstName, lastName, email, password, wallet);
                studentCollection.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentCollection;
    }
}