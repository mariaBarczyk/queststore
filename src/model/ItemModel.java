package model;


public abstract class ItemModel {
    
    private String type;
    private String name;
    private String description;
    private int ID;
    private int value;
    private int used;
    
    public ItemModel(int ID, String type, String name, String description, int value, int used) {
        this.ID = ID;
        this.type = type;
        this.name = name;
        this.description = description;
        this.value = value;
        this.used = used;
    }

    public ItemModel(String type, String name, String description, int value, int used) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.value = value;
        this.used = used;
    }

    public String getName() {
        return this.name;
    }
    public String getType() {
        return this.type;
    }
    public int getUsed() {
        return used;
    }
    public void setUsed(int used) {
        this.used = used;
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
    public int getID() {return this.ID; }
}