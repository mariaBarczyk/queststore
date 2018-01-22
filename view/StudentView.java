package queststore.view;

import queststore.model.WalletModel;
import queststore.model.ArtifactModel;

import java.util.List;

public class StudentView {

    private void displayArtifacts(WalletModel wallet) {
        List<ArtifactModel> artifactsCollection = wallet.getArtifactCollection();
        for (ArtifactModel artifact: artifactsCollection) {
            System.out.println(artifact.getName());
        }
    }

    public void displayWallet(WalletModel wallet) {
        System.out.println("\nBALANCE: " + wallet.getBalance() +
                           "\nTOTAL COOLCOINS: " + wallet.getTotalCoolcoins());
        displayArtifacts(wallet);
    }
}