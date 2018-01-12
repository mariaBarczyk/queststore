import java.util.Scanner;

public class MentorView {
    public static void displayMentorMenu(){
        System.out.println("1 - Create student's account.\n"
                + "2 - Add a new quest.\n"
                + "3 - Add new artifact to store.\n"
                + "4 - Update existing quest.\n"
                + "5 - Update existing artifact\n"
                + "6 - Mark student's achieved quests\n"
                + "7 - Mark student's bought artifacts\n"
                + "8 - See student's wallet");
    }
    public int getInput() {
        int option = 0;
        boolean optionNotSelected = true;
        while (optionNotSelected) {
            System.out.println("Select a number: ");
            Scanner scanner = new Scanner(System.in);
            try {
                option = scanner.nextInt();
                if (option>0 && option<9) {
                    optionNotSelected = false;}
                else{
                    System.out.println("Invalid input");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input!");
            }
        }
        return option;
        }

    }
