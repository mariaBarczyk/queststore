public class MentorModel extends UserModel {
    private ClassModel classAssigned;

<<<<<<< HEAD
    public MentorModel(String firstName, String lastName, String email,
                       String password, String status, ClassModel classAssigned){
        super(firstName, lastName, email, password, status);
        this.classAssigned = classAssigned;
    }
=======
    public MentorModel(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password, "Mentor");
        // TODO
    } 
    
    
>>>>>>> admin
}