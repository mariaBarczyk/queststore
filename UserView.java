import java.util.Scanner;

public class UserView {
    String userInput;
    Scanner scanner;

    public void displayLoginPanel(String email, String password){}

    public void displayWelcomeMessage(){}

    public String getUserInput(){
        boolean inputReceived = false;
        scanner = new Scanner(System.in);
        while(!inputReceived){
        if(scanner.hasNext()){
            userInput = scanner.nextLine();
            inputReceived = true;
        }else{
            System.out.println("Invalid input");}
        }
        return userInput;
    }

}
