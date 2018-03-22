package dao;

import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class TestableDatabaseUnit {

    private ManipulationDao dao;

    @BeforeAll
    static void beforeAll() throws SQLException{
        TestDatabase.prepareTestInstance();
    }

    @BeforeEach
    void beforeEach() {
        dao = new ManipulationDao();
        dao.executeUpdate("BEGIN TRANSACTION;");
    }

    @AfterEach
    void afterEach() {
        dao.executeUpdate("ROLLBACK;");
    }
}