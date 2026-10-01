import java.sql.*;
import java.util.Scanner;

public class Question4_LibraryJDBC {
    static final String URL = "jdbc:mysql://localhost:3306/appdb";
    static final String USER = "root";
    static final String PASSWORD = "your_mysql_password";

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    static void insertBook(Scanner sc) throws SQLException {
        System.out.print("Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();

        String sql = "INSERT INTO Book(BookID, Title, Author, Price, Availability) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setDouble(4, price);
            ps.setBoolean(5, true);
            ps.executeUpdate();
            System.out.println("Book inserted successfully.");
        }
    }

    static void searchBook(Scanner sc) throws SQLException {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        String sql = "SELECT * FROM Book WHERE BookID = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("BookID"));
                    System.out.println("Title: " + rs.getString("Title"));
                    System.out.println("Author: " + rs.getString("Author"));
                    System.out.println("Price: " + rs.getDouble("Price"));
                    System.out.println("Available: " + rs.getBoolean("Availability"));
                } else {
                    System.out.println("Book not found.");
                }
            }
        }
    }

    static void displayAvailable() throws SQLException {
        String sql = "SELECT * FROM Book WHERE Availability = TRUE";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getInt("BookID") + " | " +
                    rs.getString("Title") + " | " +
                    rs.getString("Author") + " | ₹" +
                    rs.getDouble("Price"));
            }
        }
    }

    static void issueBook(Scanner sc) throws SQLException {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        String sql = "UPDATE Book SET Availability = FALSE WHERE BookID = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Availability updated." : "Book not found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\n1. Insert Book");
                System.out.println("2. Search Book");
                System.out.println("3. Display Available Books");
                System.out.println("4. Issue Book");
                System.out.println("5. Exit");
                System.out.print("Choice: ");
                int choice = sc.nextInt();

                try {
                    switch (choice) {
                        case 1: insertBook(sc); break;
                        case 2: searchBook(sc); break;
                        case 3: displayAvailable(); break;
                        case 4: issueBook(sc); break;
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
