import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util. Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class UserDao {

    public static ArrayList<UserModel> usersList = new ArrayList<UserModel>();

    public UserDao(String fileName){
        
        try {
            File f = new File(fileName); 
            Scanner scan = new Scanner(f);
        
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String[] details = line.split(",");
                String firstName = details[0];
                String lastName = details[1];
                String email = details[2];
                String password = details[3];
                String status = details[4];

                UserModel user = new UserModel(firstName, lastName, email, password, status);
                
                this.usersList.add(user);
                //System.out.println(usersList);
            }
    
        } catch (FileNotFoundException e) {         
            e.printStackTrace();
        }
    }


    public ArrayList<UserModel> getUsersList() {
        return usersList;
    }


    public String checkIfUserExist(String login, String password){
        for (int i = 0; i<this.usersList.size(); i++) {
            if(this.usersList.get(i).equals("kasia@gmai.com") && this.usersList.get(3).equals("kitka")) {
                return this.usersList.get(4).toString();        
        }
      
        }    
        return null;
    } 

    public String toString(){
        String usersString = "";
        for (int i=0; i<usersList.size(); i++){
            usersString = usersString + usersList.get(i).getFirstName() + " " + usersList.get(i).getLastName() + " " + usersList.get(i).getEmail() + " " + usersList.get(i).getPassword() + " " + usersList.get(i).getStatus()+ "\n";
        }

        return usersString;

    }   
}     

