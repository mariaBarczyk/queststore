package queststore.model;

import java.util.List;
import java.util.ArrayList;

public class QuestModel extends ItemModel { 
    
    boolean used;
    private static List<QuestModel> questCollection = new ArrayList<>(); 

    public QuestModel(String type, String name, String description, int value) {
        super(type, name, description, value);
        this.used = false;
    }
    public boolean getIsUsed() {
        return this.used;
    }
}
    

