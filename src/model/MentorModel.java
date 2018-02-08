package model;

import java.util.List;
import java.util.ArrayList;

import java.util.ArrayList;

public class MentorModel extends UserModel {

    private static String status = "Mentor";
    private int idGroup;

    public MentorModel(int id, String firstName, String lastName, String email, String password, int idGroup) {
        super(id, firstName, lastName, email, password);
        this.idGroup = idGroup;
    }

    public MentorModel( String firstName, String lastName, String email, String password, int idGroup) {
        super(firstName, lastName, email, password);
        this.idGroup =idGroup ;
    }

    public int getGroup() {
        return this.idGroup;
    }

    //public void setGroup(GroupModel newGroup) {
        //this.idGroup = newGroup;
    //}
}