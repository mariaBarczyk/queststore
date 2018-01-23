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

    public void insertDataIntoTable(String table, String columns, String values) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO " + table + " " + columns + " VALUES " + values + ");";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

