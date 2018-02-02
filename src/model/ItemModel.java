package model;

import java.util.List;
import java.util.ArrayList;

public class ItemModel {

    String type;
    String name;
    String description;
    int value;
    
    public ItemModel(String type, String name, String description, int value) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.value = value;

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
    /*public static List<ItemModel> getItemCollection() {
        return itemCollection;
    }
    public static List<ItemModel> getCollectionByType(String type) {
        List<ItemModel> collectionByType = new ArrayList<>();
        for (ItemModel item: itemCollection) 
            if (item.getType().equals(type)) 
                collectionByType.add(item);
        return collectionByType;
    }*/
}