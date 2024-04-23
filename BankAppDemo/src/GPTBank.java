import java.io.*;
import java.util.Scanner;

public class GPTBank {
    private static final String FILE_NAME = "account_balance.txt";

    private double balance;

    public GPTBank() {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Invalid amount for withdrawal.");
        }
    }

    public void saveBalance() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            writer.println(balance);
            System.out.println("Balance saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving balance: " + e.getMessage());
        }
    }

    public void loadBalance() {
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            if (scanner.hasNextDouble()) {
                balance = scanner.nextDouble();
                System.out.println("Balance loaded successfully.");
            } else {
                System.out.println("No balance found.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Balance file not found. Starting with balance 0.0.");
        }
    }

    public static void main(String[] args) {
        BankingApp bankingApp = new BankingApp();
        bankingApp.loadBalance();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Save Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    bankingApp.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    bankingApp.withdraw(withdrawalAmount);
                    break;
                case 3:
                    bankingApp.saveBalance();
                    break;
                case 4:
                    bankingApp.saveBalance();
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
        System.out.println("Exiting...");
    }
}
