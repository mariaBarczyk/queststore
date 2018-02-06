package model;


public class ArtifactModel extends ItemModel { 
    
    //private int used;

    public ArtifactModel(int id, String type, String name, String description, int value, int used) {
        super(id, type, name, description, value,used);
        //this.used = used;
    }

    public ArtifactModel(String type, String name, String description, int value,int used) {
        super(type, name, description, value, used);
        //this.used = 0;

    }
}