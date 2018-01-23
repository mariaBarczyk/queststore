package model;


import java.util.List;
import java.util.ArrayList;

public class AdminModel extends UserModel {

    private static UserModel model;
    private static List<GroupModel> allGroups = new ArrayList<>();
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

