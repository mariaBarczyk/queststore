package dao;


public class MentorDao {

    public void insertNewMentor(String mentorName, String mentorLastName, String mentorEmail, String mentorPassword, String mentorGroup) {
        QueststoreDao dao = new Queststore();
        String table = "Mentor";
        String columns = "(first_name, last_name, email, password, id_status, id_group)";
        String values = "'" + mentorName + "', '" + mentorLastName + "', '" + mentorEmail + "','" + mentorPassword + "', " + 2 + ", " + 1 + "";
        dao.insertDataIntoTable(table, columns, values);
    }

    public void updateMentorData(int mentorsId, String column, String input ) {
        QueststoreDao dao = new Queststore();
        String table = "Mentor";
        String setQuery = column +"='"+input+"'";
        String condition = ("id_mentor = " + mentorsId);
        dao.updateDataInTable(table, setQuery, condition);

    }

}

