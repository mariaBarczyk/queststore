package model;


public class StudentModel extends UserModel {

    private int myGroupId;

    
    public StudentModel(String firstName, String lastName, String email, String password,
                        int groupId) {
        super(firstName, lastName, email, password);
        this.myGroupId = groupId;
    }

    public StudentModel(int id, String firstName, String lastName, String email, String password, WalletModel myWallet) {
        super(id, firstName, lastName, email, password);
    }

    public int getGroupId() {
        return this.myGroupId;
    }
    //public void setGroup(GroupModel group) { this.myGroup=group; }


}