package model;

import java.util.ArrayList;
import java.util.List;

public class StudentModel extends UserModel {

    private static String status = "Student";
    private GroupModel myGroup;
    private WalletModel myWallet;
    private static List<StudentModel> studentCollection = new ArrayList<>();
    
    public StudentModel(int id, String firstName, String lastName, String email, String password,
                        GroupModel group, WalletModel myWallet) {

        super(id, firstName, lastName, email, password);
        this.myGroup = group;
        this.myWallet = myWallet;
        studentCollection.add(this);
    }

    public GroupModel getGroup() {
        return this.myGroup;
    }  
    public WalletModel getWallet() {
        return this.myWallet;
    }
    public static List<StudentModel> getStudentsCollection() {
        return studentCollection;
    }
    public void setValuesInWallet(int value) {
        this.myWallet.setTotalCoolcoins(value);
        this.myWallet.setBalance(value);
    }
}