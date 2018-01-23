package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class MentorDB {

    public void insertNewMentor(String mentorName, String mentorLastName, String mentorEmail, String mentorPassword, String mentorGroup) {
        SqlDB dataBase = new SqlDB();
        String table = "Mentor";
        String columns = "(first_name, last_name, email, password, id_status, id_group)";
        String values = "'" + mentorName + "', '" + mentorLastName + "', '" + mentorEmail + "','" + mentorPassword + "', " + 2 + ", " + 1 + "";
        dataBase.insertDataIntoTable(table, columns, values);
    }

    public void updateMentorData(int mentorsId, String column, String input ) {
        SqlDB dataBase = new SqlDB();
        String table = "Mentor";
        String sqlQuery = "UPDATE"+ table +" SET " + column +"='"+input+"' WHERE id ="+mentorsId+";";
        dataBase.updateData(table, sqlQuery);

    }

}

