package model;

import java.util.List;
import java.util.ArrayList;

public class ItemModel {

    int id;
    String type;
    String name;
    String description;
    int value;
    
    public ItemModel(int id, String type, String name, String description, int value) {
        this.id = id;
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

    public int getID() {return this.id;}
}