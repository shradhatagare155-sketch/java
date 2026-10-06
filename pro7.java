import java.util.Scanner;

class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class Account {

    String accountHolderName;
    double accountBalance;

    Account(String accountHolderName, double accountBalance) {
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
    }

    void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Balance: ₹" + accountBalance);
    }

    void withdraw(double amount) throws InsufficientBalanceException {

        if (amount < 0) {
            throw new IllegalArgumentException(
                "Withdrawal amount cannot be negative."
            );
        }

        if (amount == 0) {
            throw new IllegalArgumentException(
                "Withdrawal amount must be greater than zero."
            );
        }

        if (amount > accountBalance) {
            throw new InsufficientBalanceException(
                "Insufficient balance. Withdrawal cannot be processed."
            );
        }

        accountBalance = accountBalance - amount;

        System.out.println("Withdrawal successful.");
        System.out.println("Amount withdrawn: ₹" + amount);
        System.out.println("Remaining balance: ₹" + accountBalance);
    }
}

public class pro7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter available account balance: ₹");

        double balance;

        try {
            balance = sc.nextDouble();
        }
        catch (java.util.InputMismatchException e) {
            System.out.println(
                "Invalid balance. Please enter a number."
            );
            sc.close();
            return;
        }

        Account account = new Account(name, balance);

        int choice;

        do {

            System.out.println("\n===== ATM WITHDRAWAL SYSTEM =====");
            System.out.println("1. Display Account Details");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Perform Multiple Withdrawals");
            System.out.println("4. Test Null Account");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
            }
            catch (java.util.InputMismatchException e) {

                System.out.println(
                    "Invalid choice. Please enter a number."
                );

                sc.nextLine();
                choice = 0;
            }

            switch (choice) {

                case 1:

                    System.out.println("\n--- Account Details ---");
                    account.displayAccountDetails();

                    break;

                case 2:

                    System.out.print("Enter withdrawal amount: ₹");

                    try {

                        double amount = sc.nextDouble();

                        account.withdraw(amount);

                    }
                    catch (InsufficientBalanceException e) {

                        System.out.println("Transaction Failed!");
                        System.out.println(e.getMessage());

                    }
                    catch (IllegalArgumentException e) {

                        System.out.println("Invalid Amount!");
                        System.out.println(e.getMessage());

                    }
                    catch (java.util.InputMismatchException e) {

                        System.out.println(
                            "Invalid input. Please enter a numeric amount."
                        );

                        sc.nextLine();
                    }

                    System.out.println(
                        "Current Balance: ₹" + account.accountBalance
                    );

                    break;

                case 3:

                    System.out.println(
                        "\n--- Multiple Withdrawals ---"
                    );

                    System.out.print(
                        "Enter first withdrawal amount: ₹"
                    );

                    try {

                        double amount1 = sc.nextDouble();

                        account.withdraw(amount1);

                        System.out.print(
                            "Enter second withdrawal amount: ₹"
                        );

                        double amount2 = sc.nextDouble();

                        account.withdraw(amount2);

                    }
                    catch (InsufficientBalanceException e) {

                        System.out.println("Transaction Failed!");
                        System.out.println(e.getMessage());

                    }
                    catch (IllegalArgumentException e) {

                        System.out.println("Invalid Amount!");
                        System.out.println(e.getMessage());

                    }
                    catch (java.util.InputMismatchException e) {

                        System.out.println(
                            "Invalid input. Please enter a numeric amount."
                        );

                        sc.nextLine();
                    }

                    System.out.println(
                        "Current Balance: ₹" + account.accountBalance
                    );

                    break;

                case 4:

                    System.out.println("\n--- Null Account Test ---");

                    Account nullAccount = null;

                    try {

                        nullAccount.withdraw(1000);

                    }
                    catch (InsufficientBalanceException e) {

                        System.out.println(
                            "Insufficient Balance: " + e.getMessage()
                        );

                    }
                    catch (NullPointerException e) {

                        System.out.println(
                            "NullPointerException: Account object is null."
                        );

                    }

                    break;

                case 5:

                    System.out.println(
                        "Thank you for using ATM Withdrawal System."
                    );

                    break;

                default:

                    if (choice != 0) {
                        System.out.println("Invalid choice.");
                    }
            }

        } while (choice != 5);

        sc.close();
    }
}