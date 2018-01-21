package queststore.model;

import queststore.model.MentorModel;
import queststore.model.GroupModel;
import java.util.List;
import java.util.ArrayList;

public class AdminModel extends UserModel {

    private static final List<GroupModel> allGroups = new ArrayList<>();
    private static String status = "Admin";
    
    public AdminModel(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }   
    
    public static List<GroupModel> getGroupList() {
        return allGroups;
    }
    public static void addToGroupList(GroupModel group) {
        allGroups.add(group);
    }
}

