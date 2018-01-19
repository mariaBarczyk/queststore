public class MentorModel extends UserModel {
    private ClassModel classAssigned;

    public MentorModel(String firstName, String lastName, String email, String password, ClassModel classAssigned) {
        super(firstName, lastName, email, password, "Mentor");
        // TODO
    }
}