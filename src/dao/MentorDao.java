package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;


import model.MentorModel;

public class MentorDao extends UserDao implements MentorDaoInterface {

    public void insertNewMentor(String mentorName, String mentorLastName, String mentorEmail, String mentorPassword, int idGroup) {
        int idStatus = findStatusIdByName("Mentor");
        insertNewLogin(mentorEmail, mentorPassword, idStatus);
        int idLogin = findLoginId(mentorEmail, mentorPassword);
        //here db connection is closed
        UserDao newDao = new UserDao();
        //int id_group = 1;
        int idGroup =
        String table = "Mentor";
        String columns = "(first_name, last_name, id_login, id_status, id_group)";
        String values = "('" + mentorName + "', '" + mentorLastName + "', " + idLogin +", "+ idStatus + ", " + idGroup + ");";
        newDao.insertDataIntoTable(table, columns, values);
    }

    private int getIdLogin(int id_mentor) {
        int id = 0;
        try {
            ResultSet result = selectDataFromTable("Mentor", "id_login", "id_mentor=" + id_mentor);
            while (result.next()) {
                id = result.getInt("id_login");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public void updateMentorData(MentorModel mentor) {

        UserDao dao = new UserDao();
        String name = mentor.getFirstName();
        String lastName = mentor.getLastName();
        String email = mentor.getEmail();
        String password = mentor.getPassword();
        int idMentor = mentor.getID();
        int idLogin = getIdLogin(idMentor);
        dao.updateDataInTable("Mentor", "first_name='"+name+"', last_name='"+lastName+"'", "id_mentor=" + idMentor);
        dao.updateDataInTable("Login", "email='"+email+"', password='"+password+"'", "id_login="+idLogin);
    }


    public List<MentorModel> getAllMentorsCollection() {

        List<MentorModel> mentorCollection = new ArrayList<>();
        UserDao dao = new UserDao();
        String columns = "email, password, Mentor.first_name, Mentor.last_name, Mentor.id_mentor";
        String joinStatement = "Mentor.id_login = Login.id_login";
        ResultSet result = dao.selectFromJoinedTables(columns, "Login", "Mentor", joinStatement);
        try {
            while (result.next()) {
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String email = result.getString("email");
                String password = result.getString("password");
                int id = result.getInt("id_mentor");
                MentorModel mentor = new MentorModel(id, firstName, lastName, email, password);
                mentorCollection.add(mentor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mentorCollection;
    }

}

