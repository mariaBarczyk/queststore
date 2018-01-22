package queststore.model;

import java.util.List;
import java.util.ArrayList;

public abstract class ItemModel {
    
    String type;
    String name;
    String description;
    int value;
    private static List<ItemModel> itemCollection = new ArrayList<>(); 
    
    public ItemModel(String type, String name, String description, int value) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.value = value;
        itemCollection.add(this);

    }
    public String getName() {
        return this.name;
    }
    public String getType() {
        return this.type;
    }
    public String getDescription() {
        return this.description;
    }
    public int getValue() {
        return this.value;
    }
    public void setValue(int newValue) {
        this.value = newValue;
    }
    public static List<ItemModel> getItemCollection() {
        return itemCollection;
    }
}