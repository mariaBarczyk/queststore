package queststore.model;


public class ArtifactModel extends ItemModel { 
    
    boolean used;

    public ArtifactModel(String type, String name, String description, int value) {
        super(type, name, description, value);
        this.used = false;    
    }
    
    public boolean getIsUsed() {
        return this.used;
    }
}