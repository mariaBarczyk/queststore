package dao;

import java.sql.*;

public class UserDao {

    private DatabaseConnection database = DatabaseConnection.getInstance();
    public Connection connection;
    private Statement statement;

    public UserDao(){
        connection = database.getConnection();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet selectDataFromTable(String tableName, String columns, String condition) {
        ResultSet result = null;
        try {
            String sql = "SELECT " + columns + " FROM " + tableName + " WHERE " + condition + ";";
            System.out.println(sql);
            result = statement.executeQuery(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return result;
    }

    public ResultSet selectFromJoinedTables(String columns, String tableName, String joinTable, String joinStatement) {
        ResultSet result = null;
        try {
            String sql = "SELECT " + columns + " FROM " + tableName + " JOIN " + joinTable + " ON " + joinStatement + ";";
            System.out.println(sql);
            result = statement.executeQuery(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return result;
    }
    
    public void insertDataIntoTable(String tableName, String columns, String values)  {
        try {
            String sql = "INSERT INTO " + tableName + columns + " VALUES " + values;
            System.out.println(sql);
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void updateDataInTable(String table, String setQuerry, String condition) {
        try {
            String sql = "UPDATE " + table + " SET " + setQuerry + " WHERE " + condition;
            System.out.println(sql);
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public int findStatusId(String login, String password) {
        int idStatus = 0;
        try {
            ResultSet result = selectDataFromTable("Login", "id_status", "email='" + login + "' AND password='" + password + "'");
            while (result.next()) return result.getInt("id_status");
            System.out.println(idStatus);
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return idStatus;
    }

    public String findStatus(int idStatus) {
        String statusName = null;
        try {
            ResultSet result = selectDataFromTable("status", "name", "id_status=" + idStatus);
            statusName = result.getString("name");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return statusName;
    }

    public int findStatusIdByName(String name) {
        int idStatus = 0;
        try {
            ResultSet result = selectDataFromTable("status", "id_status", "name='" + name + "'");
            while (result.next()) return result.getInt("id_status");
            System.out.println(idStatus);
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return idStatus;
    }

    public int findLoginId(String login, String password) {
        int loginId = 0;

        try {
            ResultSet result = selectDataFromTable("Login", "id_login", " email='" + login + "' AND password='" + password + "'");
            loginId = result.getInt("id_login");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return loginId;
    }

    public void insertNewLogin(String email, String password, int idStatus){
        String loginTable = "Login";
        String loginColumns = "(email, password, id_status)";
        String loginValues = "('"+email+"', '"+ password + "', " + idStatus + ");";
        insertDataIntoTable(loginTable, loginColumns, loginValues);

    }

    public ResultSet selectFromJoinedTablesWithCondition(String columns, String tableName, String joinTable, String joinStatement, String condition){
        ResultSet result = null;
        try {
            String sql = "SELECT " + columns + " FROM " + tableName + " JOIN " + joinTable + " ON " + joinStatement + " WHERE " + condition +";";
            System.out.println(sql);
            result = statement.executeQuery(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return result;
    }

}

