package queststore.model;

public class MentorModel extends UserModel {

    public MentorModel(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password, "Mentor");
        
    }
}