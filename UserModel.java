public abstract class UserModel {

    private Integer ID;
    private static Integer LastID = 0; 
    private String firstName;
    private String lastName;
    private String email;
    private String password;
 

    public UserModel() {
        this.ID = 0;
        this.firstName = null;
        this.lastName = null;
        this.email = null;
        this.password = null;
        
    }

    public UserModel(Integer ID, String firstName, String lastName, String email, String password) {
        this.ID = LastID;
        LastID += 1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        
       
    } 

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
 
    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String toString(){
        return "ID: " + ID + ", First name: " + this.getFirstName() + ", Last name: " + this.getLastName() + ", email: " + this.getEmail() + ", password: " + this.getPassword();
    }
    
}