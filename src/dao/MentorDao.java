package dao;


import java.sql.ResultSet;

public class MentorDao {

    public void insertNewMentor(String mentorName, String mentorLastName, String mentorEmail, String mentorPassword) {
        QueststoreDao dao = new QueststoreDao();

        String loginTable = "Login";
        int idStatus = 2;
        String loginColumns = "(email, password, id_status)";
        String loginValues = "('"+mentorEmail+"', '"+ mentorPassword + "', " + idStatus + ");";
        dao.insertDataIntoTable(loginTable, loginColumns, loginValues);

        String condition = "email = '" + mentorEmail + "' AND password = '"+mentorPassword+"'";
        int idLogin = 0;
        ResultSet idLoginResult = dao.selectDataFromTable("Login","id_login", condition);
        System.out.println(idLoginResult);
        try{
            idLogin = idLoginResult.getInt("id_login");
        } catch (Exception e) {
        }
        System.out.println(idLogin);

        int id_group = 1;
        String table = "Mentor";
        String columns = "(first_name, last_name, id_login, id_status, id_group)";
        String values = "('" + mentorName + "', '" + mentorLastName + "', " + idLogin +", "+ idStatus + ", " + id_group + ");";
        dao.insertDataIntoTable(table, columns, values);
    }

    public void updateMentorData(int mentorsId, String column, String input ) {
        QueststoreDao dao = new QueststoreDao();
        String table = "Mentor";
        String setQuery = column +"='"+input+"'";
        String condition = ("id_mentor = " + mentorsId);
        //dao.updateDataInTable(table, setQuery, condition);

    }

}

