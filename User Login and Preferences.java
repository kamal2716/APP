import javax.swing.*;
import java.awt.*;

public class UserLoginAndPreferences extends JFrame {
    JTextField usernameField;
    JPasswordField passwordField;
    JCheckBox rememberMe, notifications;

    UserLoginAndPreferences() {
        setTitle("User Login and Preferences");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        panel.add(new JLabel("Preferences:"));
        JPanel preferences = new JPanel();
        rememberMe = new JCheckBox("Remember Me");
        notifications = new JCheckBox("Receive Notifications");
        preferences.add(rememberMe);
        preferences.add(notifications);
        panel.add(preferences);

        JButton login = new JButton("Login");
        panel.add(new JLabel());
        panel.add(login);

        login.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (username.equals("admin") && password.equals("1234")) {
                String message = "Login successful!\nWelcome, " + username
                        + "\nRemember Me: " + (rememberMe.isSelected() ? "Yes" : "No")
                        + "\nReceive Notifications: " + (notifications.isSelected() ? "Yes" : "No");
                JOptionPane.showMessageDialog(this, message, "Login", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserLoginAndPreferences::new);
    }
}
