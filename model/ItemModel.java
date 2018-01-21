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
}