import java.util.ArrayList;
import java.util.List;

public class MentorDao {
    private List<MentorModel> mentorsList;

    public MentorDao() {
        this.mentorsList = new ArrayList<MentorModel>();
    }

    public List<MentorModel> getMentorsList() {
        return this.mentorsList;
    }

    public void addMentor() {
        MentorModel mentor1 = new MentorModel(1, "Karol", "Słon", "karol@gmail.com", "slon");
        MentorModel mentor2 = new MentorModel(2, "Paweł", "Koń", "pawel@gmail.com", "kon");
        MentorModel mentor3 = new MentorModel(3, "Marcin", "Kot", "marcin@gmail.com", "kot");
        this.mentorsList.add(mentor1);
        this.mentorsList.add(mentor2);
        this.mentorsList.add(mentor3);
    }

    

}
