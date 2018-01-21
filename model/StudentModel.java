package queststore.model;

public class StudentModel extends UserModel {

    private static String status = "Student";
    private GroupModel myGroup;
    private WalletModel myWallet;
    
    public StudentModel(String firstName, String lastName, String email, String password,
                        GroupModel group, WalletModel myWallet) {

        super(firstName, lastName, email, password);
        this.myGroup = group;
        this.myWallet = myWallet;
    }
    public GroupModel getGroup() {
        return this.myGroup;
    }  
    public WalletModel getWallet() {
        return this.myWallet;
    }
}