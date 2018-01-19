import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class AdminView {

    public String[] getMentorData() {
        Scanner scanner = new Scanner(System.in);
        String[] mentorData  = new String[4];
        String[] atributes = {"name", "surname", "email", "password"};
        for (String atribute: atributes) {
            System.out.println("Enter mentor " + atribute + ": ");
            String atributeValue = scanner.nextLine();
            mentorData[Arrays.asList(atributes).indexOf(atribute)] = atributeValue;
        }
        return mentorData;
    }
    public String getClassName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter class name: ");
        String className = scanner.nextLine();
        System.out.println("Mission completed.");
        return className;
    }
    public void displayMentors(List<MentorModel> mentorList) {
        for (MentorModel mentor: mentorList) {
            if (mentor != null) 
            System.out.println(mentorList.indexOf(mentor) + ". " + mentor.toString());
        }
    }
    public Integer getMentorId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter mentor ID: ");
        int mentorId = (Integer) scanner.nextInt();
        
        return mentorId;
    }
    public void displayMentorData(MentorModel mentor) {
        System.out.println(mentor.toString());
    }
    public String getUserInput(String text) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        return data;
    }
    public static void displayAdminMenu(){
        System.out.println("1 - Create mentor\n" +
                           "2 - Create class\n" + 
                           "3 - Edit mentor\n" +
                           "4 - Display mentor data\n");
    }
}


