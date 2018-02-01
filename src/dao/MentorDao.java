package dao;


public class MentorDao extends QueststoreDao{

    public void insertNewMentor(String mentorName, String mentorLastName, String mentorEmail, String mentorPassword) {
        int idStatus = findStatusIdByName("Mentor");
        insertNewLogin(mentorEmail, mentorPassword, idStatus);
        int idLogin = findLoginId(mentorEmail, mentorPassword);
        //here db connection is closed
        QueststoreDao newDao = new QueststoreDao();
        int id_group = 1;
        String table = "Mentor";
        String columns = "(first_name, last_name, id_login, id_status, id_group)";
        String values = "('" + mentorName + "', '" + mentorLastName + "', " + idLogin +", "+ idStatus + ", " + id_group + ");";
        newDao.insertDataIntoTable(table, columns, values);
    }

    private void insertNewLogin(String mentorEmail, String mentorPassword, int idStatus){
        String loginTable = "Login";
        String loginColumns = "(email, password, id_status)";
        String loginValues = "('"+mentorEmail+"', '"+ mentorPassword + "', " + idStatus + ");";
        insertDataIntoTable(loginTable, loginColumns, loginValues);
    }
}

