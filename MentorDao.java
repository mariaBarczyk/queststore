import java.util.ArrayList;
import java.util.List;

public class MentorDao {
    public static List<MentorModel> mentorsList;

    public MentorDao() {
        this.mentorsList = new ArrayList<MentorModel>();
    }

    public List<MentorModel> getMentorsList() {
        return this.mentorsList;
    }

    public void addMentor() {
        MentorModel mentor1 = new MentorModel("Karol", "Słon", "karol@gmail.com", "slon", "Mentor");
        MentorModel mentor2 = new MentorModel("Paweł", "Koń", "pawel@gmail.com", "kon", "Mentor");
        MentorModel mentor3 = new MentorModel("Marcin", "Kot", "marcin@gmail.com", "kot", "Mentor");
        this.mentorsList.add(mentor1);
        this.mentorsList.add(mentor2);
        this.mentorsList.add(mentor3);
    }

    

}
