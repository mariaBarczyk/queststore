public abstract class ItemModel {
    
        char type;
        String name;
        String description;
        int value;
        
        public ItemModel(char type, String name, String description, int value) {
            this.type = type;
            this.name = name;
            this.description = description;
            this.value = value;
        }
    }