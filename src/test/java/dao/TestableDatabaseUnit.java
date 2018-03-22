package dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.sql.SQLException;


class TestableDatabaseUnit {

    private ManipulationDao dao = new ManipulationDao();

    @BeforeEach
    void setup() {
        try {
            TestDatabase.prepareTestInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void afterEach() {
        dao.executeUpdate("ROLLBACK;");
    }
}