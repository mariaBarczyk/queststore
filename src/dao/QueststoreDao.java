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
        } catch(Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void insertDataIntoTable(String tableName, String columns, String values) {
        Connection connection = getConnection();
        try {

            Statement statement = connection.createStatement();
            String sql = "INSERT INTO " + tableName + " " + columns + " VALUES " + values + ");";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
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
            System.out.println(e.getStackTrace());
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    public ResultSet selectDataFromTable(String tableName, String columns, String condition) {
        ResultSet result = null;
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT " + columns + " FROM " + tableName + "WHERE" + condition;
            result = statement.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            closeConnection(connection);
        }
        return result;
    }


    public ResultSet getAllDataFromTable(String tableName) {
        ResultSet result = null;
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM " + tableName;
            result = statement.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            closeConnection(connection);
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
            System.out.println(e.getStackTrace());
        }
        return userExist;
    }
}

