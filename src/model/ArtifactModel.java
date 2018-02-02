package model;


public class ArtifactModel extends ItemModel { 
    
    private boolean used;

    public ArtifactModel(int id, String type, String name, String description, int value) {
        super(id, type, name, description, value);
        this.used = false;
    }

    public boolean getIsUsed() {
        return this.used;
    }



}