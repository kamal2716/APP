import javax.swing.*;
import java.awt.*;

class EmployeeModel {
    private String employeeId = "";
    private String employeeName = "";
    private String department = "";
    private String password = "admin123";

    public boolean login(String username, String password) {
        return username.equals("admin") && password.equals(this.password);
    }

    public void addEmployee(String id, String name, String dept) {
        employeeId = id;
        employeeName = name;
        department = dept;
    }

    public String getEmployee() {
        if (employeeId.isEmpty()) return "No employee added.";
        return "ID: " + employeeId + "\nName: " + employeeName +
               "\nDepartment: " + department;
    }

    public boolean changePassword(String oldPass, String newPass, String confirmPass) {
        if (!password.equals(oldPass)) return false;
        if (!newPass.equals(confirmPass) || newPass.isEmpty()) return false;
        password = newPass;
        return true;
    }
}

class LoginView extends JFrame {
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JButton login = new JButton("Login");

    LoginView() {
        setTitle("Employee Portal Login");
        setSize(350, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel p = new JPanel(new GridLayout(3, 2, 8, 8));
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        p.add(new JLabel("Username:"));
        p.add(username);
        p.add(new JLabel("Password:"));
        p.add(password);
        p.add(new JLabel(""));
        p.add(login);
        add(p);
    }
}

class MainView extends JFrame {
    JMenuItem addEmployee = new JMenuItem("Add Employee");
    JMenuItem viewEmployee = new JMenuItem("View Employee");
    JMenuItem changePassword = new JMenuItem("Change Password");
    JMenuItem logout = new JMenuItem("Logout");
    JMenuItem exit = new JMenuItem("Exit Application");

    MainView() {
        setTitle("Employee Management Portal");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar bar = new JMenuBar();

        JMenu employee = new JMenu("Employee");
        employee.add(addEmployee);
        employee.add(viewEmployee);

        JMenu tools = new JMenu("Tools");
        tools.add(changePassword);

        JMenu exitMenu = new JMenu("Exit");
        exitMenu.add(logout);
        exitMenu.add(exit);

        bar.add(employee);
        bar.add(tools);
        bar.add(exitMenu);
        setJMenuBar(bar);

        add(new JLabel("Welcome to Employee Management Portal", SwingConstants.CENTER));
    }
}

public class Question3_EmployeeManagementPortal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeModel model = new EmployeeModel();
            LoginView login = new LoginView();

            login.login.addActionListener(e -> {
                String user = login.username.getText().trim();
                String pass = new String(login.password.getPassword());

                if (model.login(user, pass)) {
                    login.dispose();
                    showMain(model);
                } else {
                    JOptionPane.showMessageDialog(login, "Invalid username or password.");
                }
            });

            login.setVisible(true);
        });
    }

    static void showMain(EmployeeModel model) {
        MainView view = new MainView();

        view.addEmployee.addActionListener(e -> {
            JTextField id = new JTextField();
            JTextField name = new JTextField();
            JTextField dept = new JTextField();

            Object[] fields = {
                "Employee ID:", id,
                "Employee Name:", name,
                "Department:", dept
            };

            int result = JOptionPane.showConfirmDialog(view, fields,
                    "Add Employee", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                if (id.getText().trim().isEmpty() || name.getText().trim().isEmpty()
                        || dept.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(view, "All fields are required.");
                } else {
                    model.addEmployee(id.getText(), name.getText(), dept.getText());
                    JOptionPane.showMessageDialog(view, "Employee added successfully.");
                }
            }
        });

        view.viewEmployee.addActionListener(e ->
            JOptionPane.showMessageDialog(view, model.getEmployee(), "Employee Details",
                    JOptionPane.INFORMATION_MESSAGE)
        );

        view.changePassword.addActionListener(e -> {
            JPasswordField oldP = new JPasswordField();
            JPasswordField newP = new JPasswordField();
            JPasswordField confirmP = new JPasswordField();

            Object[] fields = {
                "Old Password:", oldP,
                "New Password:", newP,
                "Confirm Password:", confirmP
            };

            int result = JOptionPane.showConfirmDialog(view, fields,
                    "Change Password", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                boolean changed = model.changePassword(
                    new String(oldP.getPassword()),
                    new String(newP.getPassword()),
                    new String(confirmP.getPassword())
                );

                JOptionPane.showMessageDialog(view,
                    changed ? "Password changed successfully."
                            : "Invalid old password or passwords do not match.");
            }
        });

        view.logout.addActionListener(e -> {
            view.dispose();
            LoginView login = new LoginView();
            login.login.addActionListener(x -> {
                String user = login.username.getText().trim();
                String pass = new String(login.password.getPassword());
                if (model.login(user, pass)) {
                    login.dispose();
                    showMain(model);
                } else {
                    JOptionPane.showMessageDialog(login, "Invalid username or password.");
                }
            });
            login.setVisible(true);
        });

        view.exit.addActionListener(e -> System.exit(0));
        view.setVisible(true);
    }
}
