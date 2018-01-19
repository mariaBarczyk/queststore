import java.util.ArrayList;
import java.util.List;

public class AchievementDao {

    List<AchievementModel> achievementList;

    public AchievementDao() {
        achievementList = new ArrayList<>();
    }
    public void createAchievement(char type) {
        
    }
    public List getAllAchievements() {
        return achievementList;
    }
}
