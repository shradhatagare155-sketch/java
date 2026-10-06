import java.util.Scanner;

class BankAccount {
    String accountHolderName;
    int accountNumber;
    String accountType;
    double accountBalance;

    BankAccount(String accountHolderName, int accountNumber, String accountType, double accountBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Amount Deposited: " + amount);
        } else {
            System.out.println("Invalid Deposit Amount");
        }
    }

    void withdraw(double amount) {
        if (amount > accountBalance) {
            System.out.println("Insufficient Balance");
        } else if (amount <= 0) {
            System.out.println("Invalid Withdrawal Amount");
        } else {
            accountBalance -= amount;
            System.out.println("Amount Withdrawn: " + amount);
        }
    }

    void balanceEnquiry() {
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Balance: " + accountBalance);
    }
}

public class pro1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount account = new BankAccount("Ravi", 1001, "Savings", 10000);

        int choice;

        do {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    account.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    account.withdraw(sc.nextDouble());
                    break;

                case 3:
                    account.balanceEnquiry();
                    break;

                case 4:
                    account.balanceEnquiry();
                    break;

                case 5:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}