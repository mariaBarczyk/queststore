public class MentorModel extends UserModel {
    ClassModel classAssigned;

    public MentorModel(String firstName, String lastName, String email, String password, String status, ClassModel classAssigned) {
        super(firstName, lastName, email, password, status);
        this.classAssigned = classAssigned;
    } 
    
    
}