package main.java.colormatcher.view;

import main.java.colormatcher.controller.ThinkablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/*
    ThinkPanel is a class responsible for displaying the result obtained from NeuralNet.

    by Wiktor Łazarski
 */
public class ThinkPanel extends JPanel implements ThinkablePanel {

    private final JButton thinkBtn = new JButton("THINK");
    private final JLabel inventedValueLb = new JLabel("Invented value : ");

    public ThinkPanel() {
        setLayoutManagerProperties();
        setLabelProperties();
        addComponentToGrid(thinkBtn, BorderLayout.NORTH);
        addComponentToGrid(inventedValueLb, BorderLayout.CENTER);
    }

    public void setInvention(final String invention) {
        inventedValueLb.setText("Predicted value : " + invention);
    }

    public void attachControllerToThinkButton(final ActionListener listener) {
        thinkBtn.addActionListener(listener);
    }

    public void changeBackgroundColor(final Color color) {
        for(Component comp : getComponents()) {
            comp.setBackground(color);
        }
    }

    public void changeFontColor(final Color color){
        inventedValueLb.setForeground(color);
    }

    private void setLabelProperties() {
        inventedValueLb.setFont(new Font("TimesRoman", Font.PLAIN + Font.BOLD, 20));
    }

    private void setLayoutManagerProperties() {
        LayoutManager borderLayout = new BorderLayout();
        setLayout(borderLayout);
    }

    private void addComponentToGrid(final JComponent component, final String borderLayoutPosition) {
        JPanel panel = new JPanel();
        panel.add(component);
        add(panel, borderLayoutPosition);
    }
}
