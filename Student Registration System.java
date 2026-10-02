import javax.swing.*;
import java.awt.*;

public class StudentRegistrationSystem extends JFrame {
    JTextField nameField, regField;
    JRadioButton male, female, other;
    JComboBox<String> departmentBox;

    StudentRegistrationSystem() {
        setTitle("Student Registration System");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Register Number:"));
        regField = new JTextField();
        panel.add(regField);

        panel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");
        ButtonGroup group = new ButtonGroup();
        group.add(male); group.add(female); group.add(other);
        genderPanel.add(male); genderPanel.add(female); genderPanel.add(other);
        panel.add(genderPanel);

        panel.add(new JLabel("Department:"));
        departmentBox = new JComboBox<>(new String[]{"CSE", "ECE", "EEE", "MECH", "CIVIL"});
        panel.add(departmentBox);

        JButton submit = new JButton("Submit");
        panel.add(new JLabel());
        panel.add(submit);

        submit.addActionListener(e -> {
            String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : other.isSelected() ? "Other" : "Not selected";
            String message = "Name: " + nameField.getText()
                    + "\nRegister Number: " + regField.getText()
                    + "\nGender: " + gender
                    + "\nDepartment: " + departmentBox.getSelectedItem();
            JOptionPane.showMessageDialog(this, message, "Registration Details", JOptionPane.INFORMATION_MESSAGE);
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentRegistrationSystem::new);
    }
}
