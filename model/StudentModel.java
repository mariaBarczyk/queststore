package queststore.model;

public class StudentModel extends UserModel {

    private GroupModel myGroup;
    // private WalletModel myWallet;
    
    public StudentModel(String firstName, String lastName, String email, String password, String status,
                        GroupModel group) { //WalletModel myWallet) {

        super(firstName, lastName, email, password, status);
        this.myGroup = group;
        // this.myWallet = myWallet;
    }  
}