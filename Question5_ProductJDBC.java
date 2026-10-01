import java.sql.*;
import java.util.Scanner;

public class Question5_ProductJDBC {
    static final String URL = "jdbc:mysql://localhost:3306/appdb";
    static final String USER = "root";
    static final String PASSWORD = "your_mysql_password";

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    static void insertProduct(Scanner sc) throws SQLException {
        System.out.print("Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Product Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        System.out.print("Quantity: ");
        int quantity = sc.nextInt();

        String sql = "INSERT INTO Product(ProductID, ProductName, Price, Quantity) VALUES (?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);
            ps.executeUpdate();
            System.out.println("Product inserted successfully.");
        }
    }

    static void retrieveProduct(Scanner sc) throws SQLException {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        String sql = "SELECT * FROM Product WHERE ProductID = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("ProductID"));
                    System.out.println("Name: " + rs.getString("ProductName"));
                    System.out.println("Price: " + rs.getDouble("Price"));
                    System.out.println("Quantity: " + rs.getInt("Quantity"));
                } else {
                    System.out.println("Product not found.");
                }
            }
        }
    }

    static void updateQuantity(Scanner sc) throws SQLException {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        System.out.print("Enter new quantity: ");
        int quantity = sc.nextInt();

        String sql = "UPDATE Product SET Quantity = ? WHERE ProductID = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, quantity);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Quantity updated." : "Product not found.");
        }
    }

    static void displayLowStock() throws SQLException {
        String sql = "SELECT * FROM Product WHERE Quantity < 10";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getInt("ProductID") + " | " +
                    rs.getString("ProductName") + " | ₹" +
                    rs.getDouble("Price") + " | Qty: " +
                    rs.getInt("Quantity"));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\n1. Insert Product");
                System.out.println("2. Retrieve Product");
                System.out.println("3. Update Quantity");
                System.out.println("4. Display Quantity Below 10");
                System.out.println("5. Exit");
                System.out.print("Choice: ");
                int choice = sc.nextInt();

                try {
                    switch (choice) {
                        case 1: insertProduct(sc); break;
                        case 2: retrieveProduct(sc); break;
                        case 3: updateQuantity(sc); break;
                        case 4: displayLowStock(); break;
                        case 5: return;
                        default: System.out.println("Invalid choice.");
                    }
                } catch (SQLException e) {
                    System.out.println("Database error: " + e.getMessage());
                }
            }
        } finally {
            sc.close();
        }
    }
}
