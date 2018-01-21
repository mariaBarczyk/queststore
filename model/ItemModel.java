package queststore.model;

public abstract class ItemModel {
    
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
    public String getDescription() {
        return this.name;
    }
    public String getValue() {
        return this.name;
    }
}