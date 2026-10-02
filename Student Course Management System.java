import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StudentCourseManagementSystem extends JFrame {
    JList<String> courseList;
    DefaultTableModel tableModel;
    JTable table;

    StudentCourseManagementSystem() {
        setTitle("Student Course Management System");
        setSize(750, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] courses = {"Java Programming", "Python Programming", "Data Structures", "Database Management", "Computer Networks", "Operating Systems"};
        courseList = new JList<>(courses);
        courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel leftPanel = new JPanel(new BorderLayout(5, 5));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Available Courses"));
        leftPanel.add(new JScrollPane(courseList), BorderLayout.CENTER);

        tableModel = new DefaultTableModel(new String[]{"Student Name", "Selected Course", "Enrollment Status"}, 0);
        table = new JTable(tableModel);
        JScrollPane tableScroll = new JScrollPane(table);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Registration");
        JButton removeButton = new JButton("Remove Registration");
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        addButton.addActionListener(e -> {
            String course = courseList.getSelectedValue();
            if (course == null) {
                JOptionPane.showMessageDialog(this, "Please select a course.");
                return;
            }
            String student = JOptionPane.showInputDialog(this, "Enter student name:");
            if (student != null && !student.trim().isEmpty()) {
                tableModel.addRow(new Object[]{student.trim(), course, "Enrolled"});
            }
        });

        removeButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                tableModel.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a registration to remove.");
            }
        });

        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));
        rightPanel.setBorder(BorderFactory.createTitledBorder("Student Registrations"));
        rightPanel.add(tableScroll, BorderLayout.CENTER);
        rightPanel.add(buttonPanel, BorderLayout.SOUTH);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(220);
        add(splitPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentCourseManagementSystem::new);
    }
}
