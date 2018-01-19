import java.util.List;

public interface MentorDaoInterface {
    public List<MentorModel> getMentorsList(); 
    public void createMentor(String[] mentorData, ClassModel classAssigned); 
    public void addMentor(MentorModel newMentor); 
    public MentorModel getMentor(Integer id);
}
