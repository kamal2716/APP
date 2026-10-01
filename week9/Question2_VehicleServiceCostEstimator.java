import javax.swing.*;
import java.awt.*;

class VehicleServiceModel {
    public int calculateCost(boolean general, boolean oil, boolean brake, boolean battery) {
        int cost = 0;
        if (general) cost += 1000;
        if (oil) cost += 800;
        if (brake) cost += 1200;
        if (battery) cost += 500;
        return cost;
    }
}

class VehicleServiceView extends JFrame {
    JTextField regField = new JTextField();
    JRadioButton twoWheeler = new JRadioButton("Two Wheeler", true);
    JRadioButton car = new JRadioButton("Car");
    JCheckBox general = new JCheckBox("General Service - ₹1000");
    JCheckBox oil = new JCheckBox("Oil Change - ₹800");
    JCheckBox brake = new JCheckBox("Brake Service - ₹1200");
    JCheckBox battery = new JCheckBox("Battery Check - ₹500");
    JButton calculate = new JButton("Calculate Cost");
    JLabel result = new JLabel("Total Cost: ₹0");

    VehicleServiceView() {
        setTitle("Vehicle Service Cost Estimator");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel p = new JPanel(new GridLayout(8, 1, 8, 8));
        p.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        p.add(new JLabel("Vehicle Registration Number:"));
        p.add(regField);

        JPanel type = new JPanel();
        ButtonGroup group = new ButtonGroup();
        group.add(twoWheeler);
        group.add(car);
        type.add(twoWheeler);
        type.add(car);
        p.add(type);

        p.add(general);
        p.add(oil);
        p.add(brake);
        p.add(battery);
        p.add(calculate);
        p.add(result);

        add(p);
    }
}

public class Question2_VehicleServiceCostEstimator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VehicleServiceModel model = new VehicleServiceModel();
            VehicleServiceView view = new VehicleServiceView();

            view.calculate.addActionListener(e -> {
                if (view.regField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Enter vehicle registration number.");
                    return;
                }

                int cost = model.calculateCost(
                    view.general.isSelected(),
                    view.oil.isSelected(),
                    view.brake.isSelected(),
                    view.battery.isSelected()
                );
                view.result.setText("Total Cost: ₹" + cost);
            });

            view.setVisible(true);
        });
    }
}
