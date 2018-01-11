import java.util.List;

public interface MentorDaoInterface {
<<<<<<< HEAD

    public List getAllMentors();

    public MentorModel createMentor();

    public MentorModel getMentor();
=======
    public List<MentorModel> getMentorsList(); 
    public void createMentor(String[] mentorData); 
    public void addMentor(MentorModel newMentor); 
    public MentorModel getMentor(int index);
>>>>>>> admin
}
