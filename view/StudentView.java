package queststore.view;

import queststore.model.WalletModel;
import queststore.model.ArtifactModel;
import queststore.model.ItemModel;

import java.util.List;

public class StudentView {

    public void displayCollectionOfItem(List<ItemModel> itemCollection) {
        for (ItemModel item: itemCollection) {
            System.out.println(item.getName() + item.getValue());
        }
    }

    public void displayWallet(WalletModel wallet) {
        System.out.println("\nBALANCE: " + wallet.getBalance() +
                           "\nTOTAL COOLCOINS: " + wallet.getTotalCoolcoins());
        displayCollectionOfItem(wallet.getArtifactCollection());
    }
}