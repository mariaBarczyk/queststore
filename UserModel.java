public class UserModel {

    private Integer ID;
    private static Integer LastID = 0; 
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String status;
 

    public UserModel() {
        this.ID = 0;
        this.firstName = null;
        this.lastName = null;
        this.email = null;
        this.password = null;
        this.status = null;
        
    }

    public UserModel(String firstName, String lastName, String email, String password, String status) {
        this.ID = LastID;
        LastID += 1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.status = status;    

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


    public String getStatus() {
        return this.status;
    }

    public String toString(){
        return this.firstName + " " + this.lastName + " " + this.email + " " + this.password + " " + this.status;
    }
    
}