import java.util.Scanner;

public class StudentView {
    public void displayStudentMenu(){
        System.out.println("1 - See your wallet.\n"
                + "2 - Buy artifact.\n"
                + "3 - Buy artifact together with teammates.\n"
                + "4 - See your level of experience\n");
        }

    public int getInput() {
        int option = 0;
        boolean optionNotSelected = true;
        while (optionNotSelected) {
            System.out.println("Select a number: ");
            Scanner scanner = new Scanner(System.in);
            try {
                option = scanner.nextInt();
                if (option>0 && option<5) {
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

    public void seeYourWallet(){
        WalletModel myWallet = new WalletModel();
        System.out.println("CURRENTLY IN YOUR WALLET:");
        //System.out.println(myWallet.getTotalCoolcoins());

    }
}

