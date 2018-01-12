public class QuestModel extends AchievementModel { 

    boolean used;

    public QuestModel(char type, String name, String description, int value) {
        super(type, name, description, value);
        this.used = false;

    }
}