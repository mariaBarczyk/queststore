package model;

import java.util.List;
import java.util.ArrayList;

import java.util.ArrayList;

public class MentorModel extends UserModel {

    private static String status = "Mentor";
    private GroupModel group;

    public MentorModel(int id, String firstName, String lastName, String email, String password) {
        super(id, firstName, lastName, email, password);
        this.group = null;
    }

    public MentorModel( String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
        this.group = null;
    }

    public GroupModel getGroup() {
        return this.group;
    }

    public void setGroup(GroupModel newGroup) {
        this.group = newGroup;
    }
}