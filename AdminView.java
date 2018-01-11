import java.util.Scanner;
import java.util.Arrays;

public class AdminView {

    public String[] getMentorData() {
        Scanner scanner = new Scanner(System.in);
        String[] mentorData  = new String[4];
        String[] atributes = {"name", "surname", "email", "password"};
        for (String atribute: atributes) {
            System.out.println(atribute);
            System.out.println("Enter mentor " + atribute + ": ");
            String atributeValue = scanner.nextLine();
            mentorData[Arrays.asList(atributes).indexOf(atribute)] = atributeValue;
            scanner.close();
        }
        return mentorData;
    }
    public String getUserInput(String text) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        scanner.close();
        return data;
    }
    public void displayAdminMenu(){
        System.out.println("1. Create mentor" +
                           "2. Create class" + 
                           "3. Edit mentor" +
                           "4. Display mentor data");
    }
}


