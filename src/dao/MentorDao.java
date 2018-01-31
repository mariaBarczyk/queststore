package dao;


import java.sql.ResultSet;

public class MentorDao extends QueststoreDao{

    public void insertNewMentor(String mentorName, String mentorLastName, String mentorEmail, String mentorPassword) {
        insertNewLogin(mentorEmail, mentorPassword);
        int idLogin = findIdLogin(mentorEmail, mentorPassword);
        int idStatus = findIdStatus();
        int id_group = 1;
        String table = "Mentor";
        String columns = "(first_name, last_name, id_login, id_status, id_group)";
        String values = "('" + mentorName + "', '" + mentorLastName + "', " + idLogin +", "+ idStatus + ", " + id_group + ");";
        insertDataIntoTable(table, columns, values);
    }

    private int findIdStatus(){
        String statusTable = "status";
        String statusName = "Mentor";
        String condition = "name = '"+ statusName + "'";
        int idStatus =0;
        ResultSet idStatusResult = selectDataFromTable(statusTable, "id_status",condition);
        try{
            return idStatusResult.getInt("id_status");
        } catch (Exception e) {
            e.printStackTrace();

        } return idStatus;
    }

    private void insertNewLogin(String mentorEmail, String mentorPassword){
        String loginTable = "Login";
        int idStatus = findIdStatus();
        String loginColumns = "(email, password, id_status)";
        String loginValues = "('"+mentorEmail+"', '"+ mentorPassword + "', " + idStatus + ");";
        insertDataIntoTable(loginTable, loginColumns, loginValues);
    }

    private int findIdLogin(String mentorEmail, String mentorPassword){
            String condition = "email = '" + mentorEmail + "' AND password = '"+mentorPassword+"'";
            int idLogin = 0;
            ResultSet idLoginResult = selectDataFromTable("Login","id_login", condition);
            try{
                return idLoginResult.getInt("id_login");
            } catch (Exception e) {
                e.printStackTrace();

            } return  idLogin;
    }

    /*public void updateMentorData(int mentorsId, String column, String input ) {
        String table = "Mentor";
        String setQuery = column +"='"+input+"'";
        String condition = ("id_mentor = " + mentorsId);
        //updateDataInTable(table, setQuery, condition);

    }*/

}

