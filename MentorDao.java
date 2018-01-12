import java.util.ArrayList;
import java.util.List;

public class MentorDao implements MentorDaoInterface {
    private static List<MentorModel> mentorsList = new ArrayList<>();

    public List<MentorModel> getMentorsList() {
        return mentorsList;
    }
    public void importMentorsData() {
        ClassModel class3 = new ClassModel("Group3");
        MentorModel mentor1 = new MentorModel("Karol", "Słon", "karol@gmail.com", "slon", class3);
        MentorModel mentor2 = new MentorModel("Paweł", "Koń", "pawel@gmail.com", "kon", class3);
        MentorModel mentor3 = new MentorModel("Marcin", "Kot", "marcin@gmail.com", "kot", class3);
        this.addMentor(mentor1);
        this.addMentor(mentor2);
        this.addMentor(mentor3);
    }
    public MentorModel getMentor(Integer id) { // add code to return Mentor - which Mentor?
        for (MentorModel mentor: mentorsList) {
            if (mentor != null) {
                if (mentor.getID().equals(id)) {
                    return mentor;
                }
            }
        }
        return null;
    }
    public void createMentor(String[] mentorData, ClassModel classAssigned) {
        String firstName = mentorData[0];
        String lastName = mentorData[1];
        String email = mentorData[2];
        String password = mentorData[3];
        MentorModel newMentor = new MentorModel(firstName, lastName, email, password, classAssigned);
        this.addMentor(newMentor);
    }
    public void addMentor(MentorModel newMentor) {
        mentorsList.add(newMentor);
    }

    

}
