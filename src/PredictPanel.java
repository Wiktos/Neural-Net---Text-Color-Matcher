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
        setLabelProperties();
        addComponentToGrid(predictBtn, BorderLayout.NORTH);
        addComponentToGrid(predictedValueLb, BorderLayout.CENTER);
    }

    public void setPrediction(String prediction) {
        predictedValueLb.setText("Predicted value : " + prediction);
    }

    public void attachControllerToPredictButton(ActionListener listener) {
        predictBtn.addActionListener(listener);
    }

    public void changeBackgroundColor(Color color) {
        for(Component comp : getComponents()) {
            comp.setBackground(color);
        }
    }

    public void changeFontColor(Color color){
        predictedValueLb.setForeground(color);
    }

    private void setLabelProperties() {
        predictedValueLb.setFont(new Font("TimesRoman", Font.PLAIN + Font.BOLD, 20));
    }

    private void setLayoutManagerProperties() {
        LayoutManager borderLayout = new BorderLayout();
        setLayout(borderLayout);
    }

    private void addComponentToGrid(JComponent component, String borderLayoutPosition) {
        JPanel panel = new JPanel();
        panel.add(component);
        add(panel, borderLayoutPosition);
    }
}
