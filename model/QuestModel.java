public class QuestModel extends ItemModel { 
    
        boolean used;
    
        public QuestModel(char type, String name, String description, int value) {
            super(type, name, description, value);
            this.used = false;
        }
    }
    

