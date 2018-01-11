public class ClassModel {
    
    private String name;
    private Integer ID;
    private static Integer LastID = 0; 
    
    public ClassModel() {
        this.name = null;
        this.ID = 0;
    }

    public ClassModel(String name) {
        this.name = name;
        LastID += 1;
        this.ID = LastID;
    }

    public String getName() {
        return this.name;
    }

    public Integer getID() {
        return this.ID;
    }

    public String toString() {
    
        return "ID:" + this.ID + ",name:" + this.name;
    }

}