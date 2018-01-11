import java.util.List;

public interface MentorDaoInterface {

    public List getAllMentors();

    public MentorModel createMentor();

    public MentorModel getMentor();
}
