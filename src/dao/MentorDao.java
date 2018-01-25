package dao;


public class MentorDao {

    public void insertNewMentor(String mentorName, String mentorLastName, String mentorEmail, String mentorPassword) {
        QueststoreDao dao = new QueststoreDao();
        int id_group = 1;
        String table = "Mentor";
        String columns = "(first_name, last_name, email, password, id_status, id_group)";
        String values = "('" + mentorName + "', '" + mentorLastName + "', '" + mentorEmail + "', '" + mentorPassword + "', " + 2 + ", " + id_group + "";
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

