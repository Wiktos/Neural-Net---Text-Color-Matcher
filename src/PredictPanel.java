import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Wiktor Łazarski on 23.01.2019.
 */
public class PredictPanel extends JPanel {

    private JButton predictBtn = new JButton("PREDICT");
    private JLabel predictedValueLb = new JLabel("Predicted value : ");

    public PredictPanel() {
        setLayoutManagerProperties();
        addComponentToGrid(predictBtn);
        addComponentToGrid(predictedValueLb);
    }

    public void setPrediction(String prediction) {
        predictedValueLb.setText("Predicted value : " + prediction);
    }

    public void attachControllerToPredictButton(ActionListener listener) {
        predictBtn.addActionListener(listener);
    }

    private void setLayoutManagerProperties() {
        LayoutManager gridLayout = new GridLayout(2,1);
        setLayout(gridLayout);
    }

    private void addComponentToGrid(JComponent component) {
        JPanel panel = new JPanel();
        panel.add(component);
        add(panel);
    }
}
