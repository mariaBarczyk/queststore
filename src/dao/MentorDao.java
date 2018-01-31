package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import model.MentorModel;

public class MentorDao extends QueststoreDao{

    public void insertNewMentor(String mentorName, String mentorLastName, String mentorEmail, String mentorPassword) {
        String loginTable = "Login";
        int idStatus = 2;
        String loginColumns = "'email', 'password', 'id_status'";
        String loginValues = "'"+mentorEmail+"', '"+ mentorPassword + "', " + idStatus;
        insertDataIntoTable(loginTable, loginColumns, loginValues);

        String condition = "email = '" + mentorEmail + "' AND password = '"+mentorPassword+"'";
        int idLogin = 0;
        ResultSet idLoginResult = selectDataFromTable("Login","id_login", condition);
        try{
            idLogin = idLoginResult.getInt("id_login");
        } catch (Exception e) {
        }

        int id_group = 1;
        String table = "Mentor";
        String columns = "'first_name', 'last_name', 'id_login', 'id_status', id_group";
        String values = "'" + mentorName + "', '" + mentorLastName + "', " + idLogin +", "+ idStatus + ", " + id_group;
        insertDataIntoTable(table, columns, values);
    }

    public void updateMentorData(int mentorsId, String column, String newData ) {
        String table = "Mentor";
        String setQuery = column +"='"+ newData +"'";
        String condition = ("id_mentor = " + mentorsId);
        QueststoreDao dao = new QueststoreDao();
        dao.updateDataInTable(table, setQuery, condition);

    }
    public List<MentorModel> getAllMentorsCollection() {

        List<MentorModel> mentorCollection = new ArrayList<>();
        QueststoreDao dao = new QueststoreDao();
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

