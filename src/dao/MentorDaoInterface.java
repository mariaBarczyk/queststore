package dao;

import model.MentorModel;

import java.util.List;

public interface MentorDaoInterface {

//    void insertNewMentor(String mentorName, String mentorLastName, String mentorEmail, String mentorPassword);
//    void updateMentorData(MentorModel mentor);
    List<MentorModel> getAllMentorsCollection();

}
