package view;

import model.WalletModel;
import model.ArtifactModel;
import model.ItemModel;

import java.util.List;

public class StudentView {

    public void displayStudentMenu(){
        System.out.println("1 - See your wallet.\n"
                + "2 - Buy artifact.\n"
                + "3 - Buy artifact together with teammates.\n"
                + "4 - See your level of experience\n");
    }

    public void displayCollectionOfItem(List<ItemModel> itemCollection) {
        for (ItemModel item: itemCollection) {
            System.out.println(item.getID() + ". " + item.getName() + item.getValue());
        }
    }

    public void displayWallet(WalletModel wallet) {
        System.out.println("\nBALANCE: " + wallet.getBalance() +
                           "\nTOTAL COOLCOINS: " + wallet.getTotalCoolcoins());
//        displayCollectionOfItem(wallet.getArtifactCollection());
    }
}