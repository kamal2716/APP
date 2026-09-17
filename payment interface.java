import java.util.Scanner;

interface Payment {
    void makePayment(double amount);
}

class UPI implements Payment {
    public void makePayment(double amount) {
        System.out.println("UPI payment of Rs. " + amount + " successful.");
    }
}

class CreditCard implements Payment {
    public void makePayment(double amount) {
        System.out.println("Credit Card payment of Rs. " + amount + " successful.");
    }
}

class NetBanking implements Payment {
    public void makePayment(double amount) {
        System.out.println("Net Banking payment of Rs. " + amount + " successful.");
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. UPI");
        System.out.println("2. Credit Card");
        System.out.println("3. Net Banking");
        System.out.print("Select payment method: ");
        int choice = sc.nextInt();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        Payment payment;

        if (choice == 1)
            payment = new UPI();
        else if (choice == 2)
            payment = new CreditCard();
        else if (choice == 3)
            payment = new NetBanking();
        else {
            System.out.println("Invalid choice.");
            sc.close();
            return;
        }

        payment.makePayment(amount);
        sc.close();
    }
}
