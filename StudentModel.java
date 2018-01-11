public class StudentModel extends UserModel {
    ClassModel myClass;
    WalletModel myWallet;
    
    
    public StudentModel(String firstName, String lastName, String email, String password, String status, ClassModel myClass, WalletModel myWallet) {

        super(firstName, lastName, email, password, status);
        this.myClass = myClass;
        this.myWallet = myWallet;


    } 
    
}