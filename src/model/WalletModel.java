package model;

import java.util.ArrayList;
import java.util.List;

public class WalletModel {

    private int totalCoolcoins;
    private int balance;
    private List<ItemModel> artifactCollection;

    public WalletModel() {
        this.totalCoolcoins = 0;
        this.balance = 0;
        this.artifactCollection = new ArrayList<>();
    }
    public int getBalance() {
        return balance;
    }
    public int getTotalCoolcoins() {
        return totalCoolcoins;
    }
    public void setTotalCoolcoins(int value) {
        this.totalCoolcoins += value;
    }
    public void setBalance(int value) {
        this.balance += value;
    }
    public  List<ItemModel> getArtifactCollection() {
        return artifactCollection;
    }
}