package queststore.model;

public class MentorModel extends UserModel {

    private GroupModel group;

    public MentorModel(String firstName, String lastName, String email, String password, GroupModel group) {
        super(firstName, lastName, email, password, "Mentor");
        this.group = group  ; 
    }

    public GroupModel getGroup() {
        return this.group;
    }

}