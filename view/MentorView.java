package queststore.view;

public class MentorView {

    public static void displayMentorMenu(){
        System.out.println( "\nMENU:\n"
                            + "1 - Create student's account.\n"
                            + "2 - Add a new quest.\n"
                            + "3 - Add new artifact to store.\n"
                            + "4 - Update existing quest.\n"
                            + "5 - Update existing artifact\n"
                            + "6 - Mark student's achieved quests\n"
                            + "7 - Mark student's bought artifacts\n"
                            + "8 - See student's wallet\n");
    }
}