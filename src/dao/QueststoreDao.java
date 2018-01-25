package dao;

import java.sql.*;


public class QueststoreDao {

    private Statement statement;
    private Connection connection;

    public QueststoreDao(){
        this.connection = getConnection();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:Queststore.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public ResultSet selectDataFromTable( String tableName, String columns, String condition) {
        ResultSet result = null;
        try {
            String sql = "SELECT " + columns + " FROM " + tableName + " WHERE " + condition + ";";
            System.out.println(sql);
            result = statement.executeQuery(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//        } finally {
//            closeConnection();
        }
        return result;
    }
    
    public void insertDataIntoTable(String tableName, String columns, String values) {
        try {
            String sql = "INSERT INTO " + tableName + " " + columns + " VALUES " + values;
            System.out.println(sql);
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//        } finally {
//            closeConnection();
        }
    }

    public int findStatusId(String login, String password) {
        int idStatus = 0;
        ResultSet result = selectDataFromTable("Login", "id_status", "email='" + login + "' AND password='" + password + "'");
        try {
            while (result.next())
                idStatus = result.getInt("id_status");
                System.out.println(idStatus);
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return idStatus;
    }

    public String findStatus(int idStatus) {
        ResultSet result = selectDataFromTable("status", "name", "id_status=" + idStatus);
        String statusName = null;
        try {
            statusName = result.getString("name");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            closeConnection();
        }
        return statusName;
    }

    public int findLoginId(String login, String password) {
        int loginId = 0;
        ResultSet result = selectDataFromTable("Login", "id_login", " email='" + login + "' AND password='" + password + "'");
        try {
            loginId = result.getInt("id_login");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            closeConnection();
        }
        return loginId;
    }
}

