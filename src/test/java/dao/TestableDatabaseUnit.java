package dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class TestableDatabaseUnit {

    private ManipulationDao dao;

    @BeforeAll
    static void beforeAll() {
        try {
            TestDatabase.prepareTestInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    void beforeEach() {
        dao = new ManipulationDao();
    }

    @AfterEach
    void afterEach() {
        dao.executeUpdate("ROLLBACK;");
    }
}