package dao;

import java.sql.*;


public final class DatabaseConnection {

    private static DatabaseConnection instance = null;
    private Connection connection = null;
    private final String DBNAME = "jdbc:sqlite:Queststore.db";

    private DatabaseConnection() {
        getConnectionToDatabase();
    }
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private void getConnectionToDatabase () {
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection(DBNAME);
        } catch (SQLException | NullPointerException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("DB connection problem.");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("Class not found.");
        }
    }

    public Connection getConnection () {
        return connection;
    }
}