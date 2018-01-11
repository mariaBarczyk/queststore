public class QuestModel extends AchievementModel { 

    boolean used;

    public QuestModel(char type, String name, String description, int value, boolean used) {
        super(type, name, description, value);
        this.used = used;

    }
}