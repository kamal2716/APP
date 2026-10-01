import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class StudentModel {
    private String name;
    private int m1, m2, m3;
    private int total;
    private double average;
    private String grade;

    public void calculate(String name, int m1, int m2, int m3) {
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        total = m1 + m2 + m3;
        average = total / 3.0;

        if (average >= 90) grade = "A";
        else if (average >= 75) grade = "B";
        else if (average >= 60) grade = "C";
        else if (average >= 50) grade = "D";
        else grade = "F";
    }

    public String getResult() {
        return "Student: " + name +
               "\nTotal: " + total +
               "\nAverage: " + String.format("%.2f", average) +
               "\nGrade: " + grade;
    }
}

class StudentView extends JFrame {
    JTextField nameField = new JTextField();
    JTextField mark1Field = new JTextField();
    JTextField mark2Field = new JTextField();
    JTextField mark3Field = new JTextField();
    JButton calculateButton = new JButton("Calculate Result");
    JTextArea resultArea = new JTextArea(6, 25);

    StudentView() {
        setTitle("Student Grade Calculator");
        setSize(420, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panel.add(new JLabel("Student Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Subject 1:"));
        panel.add(mark1Field);
        panel.add(new JLabel("Subject 2:"));
        panel.add(mark2Field);
        panel.add(new JLabel("Subject 3:"));
        panel.add(mark3Field);
        panel.add(new JLabel(""));
        panel.add(calculateButton);
        panel.add(new JLabel("Result:"));
        panel.add(new JScrollPane(resultArea));

        add(panel);
        resultArea.setEditable(false);
    }
}

public class Question1_StudentGradeCalculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentModel model = new StudentModel();
            StudentView view = new StudentView();

            view.calculateButton.addActionListener(e -> {
                try {
                    String name = view.nameField.getText().trim();
                    if (name.isEmpty()) throw new Exception("Enter student name.");

                    int m1 = Integer.parseInt(view.mark1Field.getText().trim());
                    int m2 = Integer.parseInt(view.mark2Field.getText().trim());
                    int m3 = Integer.parseInt(view.mark3Field.getText().trim());

                    if (m1 < 0 || m1 > 100 || m2 < 0 || m2 > 100 || m3 < 0 || m3 > 100)
                        throw new Exception("Marks must be between 0 and 100.");

                    model.calculate(name, m1, m2, m3);
                    view.resultArea.setText(model.getResult());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(view, "Enter valid marks.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view, ex.getMessage());
                }
            });

            view.setVisible(true);
        });
    }
}
