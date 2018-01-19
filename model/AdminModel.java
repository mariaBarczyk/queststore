package queststore.model;

import queststore.model.MentorModel;
import java.util.List;
import java.util.ArrayList;

public class AdminModel extends UserModel {

    private static final List<GroupModel> allGroups = new ArrayList<>();
    
    public AdminModel(String firstName, String lastName, String email, String password, String status) {
        super(firstName, lastName, email, password, status);
    }   
    
    public static List<GroupModel> getGroupList() {
        return allGroups;
    }
}