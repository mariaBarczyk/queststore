import java.util.ArrayList;
import java.util.List;

public class MentorDao implements MentorDaoInterface {
    private static List<MentorModel> mentorsList;

    public MentorDao() {
        mentorsList = new ArrayList<MentorModel>();
    }
    public List<MentorModel> getMentorsList() {
        return mentorsList;
    }
    public void importMentorsData() {
        MentorModel mentor1 = new MentorModel("Karol", "Słon", "karol@gmail.com", "slon");
        MentorModel mentor2 = new MentorModel("Paweł", "Koń", "pawel@gmail.com", "kon");
        MentorModel mentor3 = new MentorModel("Marcin", "Kot", "marcin@gmail.com", "kot");
        this.addMentor(mentor1);
        this.addMentor(mentor2);
        this.addMentor(mentor3);
    }
    public MentorModel getMentor(int index) { // add code to return Mentor - which Mentor?
        return mentorsList.get(index);
    }
    public void createMentor(String[] mentorData) {
        String firstName = mentorData[0];
        String lastName = mentorData[1];
        String email = mentorData[2];
        String password = mentorData[3];
        MentorModel newMentor = new MentorModel(firstName, lastName, email, password);
        this.addMentor(newMentor);
    }
    public void addMentor(MentorModel newMentor) {
        mentorsList.add(newMentor);
    }

    

}
