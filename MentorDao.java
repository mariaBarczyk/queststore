import java.util.ArrayList;
import java.util.List;

public class MentorDao implements MentorModelInterface {
    private static List<MentorModel> mentorsList;

    public MentorDao() {
        mentorsList = new ArrayList<MentorModel>();
    }
    public List<MentorModel> getMentorsList() {
        return mentorsList;
    }
    public void importMentorsData() {
        MentorModel mentor1 = new MentorModel("Karol", "Słon", "karol@gmail.com", "slon", "Mentor");
        MentorModel mentor2 = new MentorModel("Paweł", "Koń", "pawel@gmail.com", "kon", "Mentor");
        MentorModel mentor3 = new MentorModel("Marcin", "Kot", "marcin@gmail.com", "kot", "Mentor");
        mentorsList.addMentor(mentor1);
        mentorsList.addMentor(mentor2);
        mentorsList.addMentor(mentor3);
    }
    public void getMentor() {
    }
    public void createMentor(String[] mentorData) {
        String firstName = mentorData[0];
        String lastName = mentorData[1];
        String email = mentorData[2];
        String password = mentorData[3];
        String status = "M";
        MentorModel newMentor = new MentorModel(firstName, lastName, email, password, status);
    }
    public void addMentor(MentorModel newMentor) {
        mentorsList.add(newMentor);
    }

    

}
