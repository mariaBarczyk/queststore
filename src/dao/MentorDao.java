package dao;


import java.sql.ResultSet;

public class MentorDao extends QueststoreDao{

    public void insertNewMentor(String mentorName, String mentorLastName, String mentorEmail, String mentorPassword) {
        String loginTable = "Login";
        int idStatus = 2;
        String loginColumns = "(email, password, id_status)";
        String loginValues = "('"+mentorEmail+"', '"+ mentorPassword + "', " + idStatus + ");";
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
        String columns = "(first_name, last_name, id_login, id_status, id_group)";
        String values = "('" + mentorName + "', '" + mentorLastName + "', " + idLogin +", "+ idStatus + ", " + id_group + ");";
        insertDataIntoTable(table, columns, values);
    }

    public void updateMentorData(int mentorsId, String column, String input ) {
        String table = "Mentor";
        String setQuery = column +"='"+input+"'";
        String condition = ("id_mentor = " + mentorsId);
        //updateDataInTable(table, setQuery, condition);

    }

}

