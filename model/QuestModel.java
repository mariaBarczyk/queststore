package queststore.model;

import java.util.List;
import java.util.ArrayList;

public class QuestModel extends ItemModel { 
    
        boolean used;
        private static List<QuestModel> questCollection = new ArrayList<>(); 
    
        public QuestModel(char type, String name, String description, int value) {
            super(type, name, description, value);
            this.used = false;
        }
    }
    

