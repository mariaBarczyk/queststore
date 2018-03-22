package dao;


import model.MentorModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MentorDaoTest extends TestableDatabaseUnit {

    private MentorDao dao = new MentorDao();

    @Test
    void testMentorInsertion() {
        MentorModel mentor = new MentorModel(
                "TestMan",
                "SuperMan",
                "superman@test.com",
                "superpassword",
                1);

        dao.insertNewMentor(mentor);
        String query =
                "SELECT first_name, last_name, Mentor.id_login, Mentor.id_status, id_group, email, password " +
                " FROM Mentor" +
                "  INNER JOIN Login ON Mentor.id_login = Login.id_login" +
                "   WHERE first_name LIKE 'TestMan' AND last_name LIKE 'SuperMan' AND email LIKE 'superman@test.com' AND password LIKE 'superpassword'" +
                "    AND Mentor.id_login NOT NULL AND Mentor.id_status NOT NULL AND id_group NOT NULL;";
        ResultSet rs = dao.executeSelect(query);
        boolean insertionSuccessful = false;
        try {
            insertionSuccessful = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertTrue(insertionSuccessful);
    }
}