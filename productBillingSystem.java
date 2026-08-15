import java.util.Scanner;
class Product {
    int id;
    String name;
    double price;
    int quantity;
}
public class productBillingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] products = new Product[5]; 
        for (int i = 0; i < 5; i++) {
            products[i] = new Product(); 
            
            System.out.println("Product " + (i + 1) + ":");
            System.out.print("ID: ");
            products[i].id =sc.nextInt();
            sc.nextLine(); 
            System.out.print("Name: ");
            products[i].name = sc.nextLine();
            System.out.print("Price: ");
            products[i].price = sc.nextDouble();
            System.out.print("Quantity: ");
            products[i].quantity = sc.nextInt();
            System.out.println();
        }
        System.out.println("Output:");
        for (int i = 0; i < 5; i++) {
            double totalPrice = products[i].price * products[i].quantity;
            double discount = 0;
            if (totalPrice >= 5000) {
                discount = totalPrice * 0.10; 
            } else {
                discount = totalPrice * 0.05; 
            }
            double finalPrice = totalPrice - discount;
            System.out.println("Product ID: " + products[i].id);
            System.out.println("Name: " + products[i].name);
            System.out.println("Total Price: ₹" + (int)totalPrice);
            System.out.println("Discount: ₹" + (int)discount);
            System.out.println("Final Price: ₹" + (int)finalPrice);
            System.out.println();
        }
        sc.close();
    }
}