package view;


import model.MentorModel;

import java.util.List; 

public class AdminView {

    public void displayAdminMenu(){
        System.out.println("\nMENU: \n" +
                            "1 - Create mentor\n" +
                            "2 - Create new group\n" + 
                            "3 - Edit mentor\n" +
                            "4 - Display mentor data\n" +
                            "5 - Exit\n");
    }

    public void displayEditMentorMenu() {
        System.out.println("\nSelect field to edit: \n"
                              + "1. name\n"
                              + "2. last name\n"
                              + "3. email\n"
                              + "4. password\n"
                              + "5. group\n"
                              + "6. exit\n");
    }
    public void displayAllMentors(List<MentorModel> mentorsCollection) {
        for (MentorModel mentor: mentorsCollection) {
            System.out.println(mentor.getFullName()); 
        }
    }
    public void displayMentorData(MentorModel mentor) {
        System.out.println("\n===MENTOR DATA==\n"
                         + mentor.getFullName() 
                         + "\nemail: " + mentor.getEmail() 
                         + "\npassword: " + mentor.getPassword()
                         + "\ngroup name: " + mentor.getGroup().getGroupName() + '\n');
    }
}