package queststore.model;

import java.util.List;
import java.util.ArrayList;

import java.util.ArrayList;

public class MentorModel extends UserModel {

    private static String status = "Mentor";
    private GroupModel group;
    private static List<MentorModel> mentorsCollection = new ArrayList<>(); 

    public MentorModel(String firstName, String lastName, String email, String password, GroupModel group) {
        super(firstName, lastName, email, password);
        this.group = group; 
        mentorsCollection.add(this);
    }

    public GroupModel getGroup() {
        return this.group;
    }
    public static List<MentorModel> getMentorsCollection() { 
        return mentorsCollection;
    }
    public void setGroup(GroupModel newGroup) {
        this.group = newGroup;
    }
}