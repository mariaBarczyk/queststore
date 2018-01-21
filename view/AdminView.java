package queststore.view;


import queststore.model.MentorModel;
import java.util.List; 

public class AdminView {

    public void displayAdminMenu(){
        System.out.println("MENU: \n" +
                            "1 - Create mentor\n" +
                            "2 - Create class\n" + 
                            "3 - Edit mentor\n" +
                            "4 - Display mentor data\n");
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
        System.out.println(mentor.toString());
    }
}