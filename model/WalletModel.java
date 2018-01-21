package queststore.model;

// import java.util.ArrayList;
// import java.util.List;

public class WalletModel {

    private int totalCoolcoins;
    private int balance;
    // private List<ArtifactModel> artifactCollection;

    public WalletModel() {
        this.totalCoolcoins = 0;
        this.balance = 0;
        // this.artifactCollection = new ArrayList<ArtifactModel>();
    }
    public int getBalance() {
        return balance;
    }
    public int getTotalCoolcoins() {
        return totalCoolcoins;
    }
}