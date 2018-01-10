import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util. Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class UserDao {

    private ArrayList<String> usersList = new ArrayList<String>();

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
    
                this.usersList.add(details[0]);
                this.usersList.add(details[1]);
                this.usersList.add(details[2]);
                this.usersList.add(details[3]);
                this.usersList.add(details[4]);
                System.out.println(Arrays.toString(details));
            }
    
        } catch (FileNotFoundException e) {         
            e.printStackTrace();
        }
    }

    public ArrayList<String> getUsersList() {
        return usersList;
    }


}    