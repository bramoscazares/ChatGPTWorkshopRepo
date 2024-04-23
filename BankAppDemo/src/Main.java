import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Txt file feature to save and load bank acocunts

        // withdraw and deposit feature


        System.out.println("Welcome to the Banking App");
        //print out the menu
        System.out.println("1. Create a new account");
        System.out.println("2. Load an existing account");
        System.out.println("3. Exit");

        Account accountTest = new Account("John Doe", 1000.0);

        Account account = new Account("Dr B", 100000);
        //get the user's choice
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        //process the choice
        switch (choice) {
            case 1:
                //As user for a name
                System.out.print("Enter your name: ");
                String name = scanner.next();
                //As user for a balance
                System.out.print("Enter your balance: ");
                double balance = scanner.nextDouble();
                //Create a new account
                account = new Account(name, balance);
                break;
            case 2:
                //As User to give a text file name
                System.out.print("Enter the name of the file: ");
                String filename = scanner.next();
                //Load the account from the file
                account = Account.loadFromFile(filename);
                if (account == null) {
                    System.out.println("Account not found.");
                }
                break;
            case 3:
                //End Program
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }






//        public static void main(String[] args) {
//            Account account = new Account("John Doe", 1000.0);
//            account.saveToFile("account.txt");
//
//            Account loadedAccount = Account.loadFromFile("account.txt");
//            if (loadedAccount != null) {
//                System.out.println("Loaded Account: " + loadedAccount);
//            }
//        }



    }

}
