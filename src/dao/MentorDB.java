package dao;


public class MentorDB {

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
        String sqlQuery = "UPDATE"+ table +" SET " + column +"='"+input+"' WHERE id ="+mentorsId+";";
        dao.updateDataInTable(table, sqlQuery);

    }

}

