package dao;

import java.sql.*;

public class UserDao implements UserDaoInterface {

    private DatabaseConnection database = DatabaseConnection.getInstance();
    private Connection connection;
    private Statement statement;

    public UserDao(){
        connection = database.getConnection();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet executeSelect(String sql) {
        ResultSet result = null;
        try {
            result = statement.executeQuery(sql);
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return result;
    }

    public void executeUpdate(String sql) {
        try {
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public int getIntFromResult(ResultSet result, String columnName) {
        int intData = 0;
        try {
            intData = result.getInt(columnName);
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return intData;
    }

    public String getStringFromResult(ResultSet result, String columnName) {
        String stringData = null;
        try {
            stringData = result.getString(columnName);
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return stringData;
    }

    public ResultSet selectDataFromTable(String tableName, String columns, String condition) {
        String sql = "SELECT " + columns + " FROM " + tableName + " WHERE " + condition + ";";
        return executeSelect(sql);

    }

    public ResultSet selectFromJoinedTables(String columns, String tableName, String joinTable, String joinStatement) {
        String sql = "SELECT " + columns + " FROM " + tableName + " JOIN " + joinTable + " ON " + joinStatement + ";";
        return  executeSelect(sql);

    }
    
    public void insertDataIntoTable(String tableName, String columns, String values) {
        String sql = "INSERT INTO " + tableName + columns + " VALUES " + values;
        executeUpdate(sql);
    }

    public void updateDataInTable(String table, String setQuerry, String condition) {
        String sql = "UPDATE " + table + " SET " + setQuerry + " WHERE " + condition;
        executeUpdate(sql);
    }

//    public int findStatusId(String login, String password) {
//        int idStatus = 0;
//        try {
//            ResultSet result = selectDataFromTable("Login", "id_status", "email='" + login + "' AND password='" + password + "'");
//            while (result.next())
//                idStatus = result.getInt("id_status");
//        } catch (SQLException e) {
//            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//        }
//        return idStatus;
//    }
//
//    public String findStatus(int idStatus) {
//        String statusName = null;
//        try {
//            ResultSet result = selectDataFromTable("status", "name", "id_status=" + idStatus);
//            statusName = result.getString("name");
//        } catch (Exception e) {
//            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//        }
//        return statusName;
//    }
//
//    public int findStatusIdByName(String name) {
//        int idStatus = 0;
//        try {
//            ResultSet result = selectDataFromTable("status", "id_status", "name='" + name + "'");
//            while (result.next())
//                idStatus =  result.getInt("id_status");
//            System.out.println(idStatus);
//        } catch (SQLException e) {
//            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//        }
//        return idStatus;
//    }
//
//    public int findLoginId(String login, String password) {
//        int loginId = 0;
//
//        try {
//            ResultSet result = selectDataFromTable("Login", "id_login", " email='" + login + "' AND password='" + password + "'");
//            loginId = result.getInt("id_login");
//        } catch (Exception e) {
//            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//        }
//        return loginId;
//    }
//
//    public void insertNewLogin(String email, String password, int idStatus){
//        String loginTable = "Login";
//        String loginColumns = "(email, password, id_status)";
//        String loginValues = "('"+email+"', '"+ password + "', " + idStatus + ");";
//        insertDataIntoTable(loginTable, loginColumns, loginValues);
//
//    }
}

