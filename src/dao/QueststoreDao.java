package dao;

import java.sql.*;


public class QueststoreDao {

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

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void insertDataIntoTable(String tableName, String columns, String values) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO " + tableName + " " + columns + " VALUES " + "("+ values + ");";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet selectDataFromTable(String tableName, String columns) {
        ResultSet result = null;
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT " + columns + " FROM " + tableName;

            result = statement.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    public ResultSet selectDataFromTable(String tableName, String columns, String condition) {
        ResultSet result = null;
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT " + tableName + " FROM " + columns + " WHERE " + condition;
            result = statement.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public ResultSet getAllDataFromTable(String tableName) {
        ResultSet result = null;
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM " + tableName;
            statement.executeUpdate(sql);
            result = statement.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return result;
    }

    public boolean checkIfUserExist(String login, String password) {
        boolean userExist = false;
        String loginData = login + " " + password;
        ResultSet result = selectDataFromTable("Login", "email||' '|||password AS full_login", "full_login=" + loginData);
        try {
            userExist = result.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userExist;
    }
}
