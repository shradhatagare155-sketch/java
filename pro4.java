import java.util.Scanner;

class Payment {
    void makePayment(double amount) {
        System.out.println("Payment of Rs." + amount + " processed.");
    }

    void makePayment(double amount, String transactionId) {
        System.out.println("Payment of Rs." + amount + " processed. Transaction ID: " + transactionId);
    }
}

class CreditCardPayment extends Payment {
    @Override
    void makePayment(double amount) {
        System.out.println("Credit Card payment: Rs." + amount);
    }
}

class UPIPayment extends Payment {
    @Override
    void makePayment(double amount) {
        System.out.println("UPI payment: Rs." + amount);
    }
}

class NetBankingPayment extends Payment {
    @Override
    void makePayment(double amount) {
        System.out.println("Net Banking payment: Rs." + amount);
    }
}

public class pro4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Payment payment;
        int choice;

        do {
            System.out.println("\n1. Credit Card");
            System.out.println("2. UPI");
            System.out.println("3. Net Banking");
            System.out.println("4. Payment with Transaction ID");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double amount1 = sc.nextDouble();
                    payment = new CreditCardPayment();
                    payment.makePayment(amount1);
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    double amount2 = sc.nextDouble();
                    payment = new UPIPayment();
                    payment.makePayment(amount2);
                    break;

                case 3:
                    System.out.print("Enter amount: ");
                    double amount3 = sc.nextDouble();
                    payment = new NetBankingPayment();
                    payment.makePayment(amount3);
                    break;

                case 4:
                    System.out.print("Enter amount: ");
                    double amount4 = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter transaction ID: ");
                    String id = sc.nextLine();
                    payment = new Payment();
                    payment.makePayment(amount4, id);
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