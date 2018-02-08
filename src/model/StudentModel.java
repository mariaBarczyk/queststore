package model;


public class StudentModel extends UserModel {

    private GroupModel myGroup;
    private WalletModel myWallet;

    
    public StudentModel(int id, String firstName, String lastName, String email, String password,
                        GroupModel group, WalletModel myWallet) {
        super(id, firstName, lastName, email, password);
        this.myGroup = group;
        this.myWallet = myWallet;
    }

    public StudentModel(int id, String firstName, String lastName, String email, String password, WalletModel myWallet) {
        super(id, firstName, lastName, email, password);
        this.myWallet = myWallet;
    }

    public void updateAcountBalance(int value){
        this.myWallet.setBalance(value);
        this.myWallet.setTotalCoolcoins(value);
    }

    public GroupModel getGroup() {
        return this.myGroup;
    }
    public void setGroup(GroupModel group) { this.myGroup=group; }
    public WalletModel getWallet() {
        return this.myWallet;
    }

}