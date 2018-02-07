package model;


public class ArtifactModel extends ItemModel {

    public ArtifactModel(int id, String type, String name, String description, int value) {
        super(id, type, name, description, value);
    }

    public ArtifactModel(String type, String name, String description, int value) {
        super(type, name, description, value);

    }
}