import java.util.ArrayList;

public class WalletModel {
    private int totalCoolcoins;
    private int balance;
    private ArrayList<ArtifactModel> artifactCollection;

    public WalletModel(){
        this.totalCoolcoins = 0; //potrzebne potem do leveli
        this.balance = 0;
        this.artifactCollection = new ArrayList<ArtifactModel>();
    }

    public int getBalance() {
        return balance;
    }

<<<<<<< HEAD
}
<<<<<<< HEAD
=======
    public int getTotalCoolcoins() {
        return totalCoolcoins;
    }
>>>>>>> a15a019078b2fc633d9d9165085a973d19401ad9

    public ArrayList<ArtifactModel> getArtifactCollection() {
        return artifactCollection;
    }
}

=======
>>>>>>> login
