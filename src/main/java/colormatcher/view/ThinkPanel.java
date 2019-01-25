package main.java.colormatcher.view;

import main.java.colormatcher.controller.ThinkablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ThinkPanel extends JPanel implements ThinkablePanel {

    private JButton thinkBtn = new JButton("THINK");
    private JLabel inventedValueLb = new JLabel("Invented value : ");

    public ThinkPanel() {
        setLayoutManagerProperties();
        setLabelProperties();
        addComponentToGrid(thinkBtn, BorderLayout.NORTH);
        addComponentToGrid(inventedValueLb, BorderLayout.CENTER);
    }

    public void setInvention(String invention) {
        inventedValueLb.setText("Predicted value : " + invention);
    }

    public void attachControllerToThinkButton(ActionListener listener) {
        thinkBtn.addActionListener(listener);
    }

    public void changeBackgroundColor(Color color) {
        for(Component comp : getComponents()) {
            comp.setBackground(color);
        }
    }

    public void changeFontColor(Color color){
        inventedValueLb.setForeground(color);
    }

    private void setLabelProperties() {
        inventedValueLb.setFont(new Font("TimesRoman", Font.PLAIN + Font.BOLD, 20));
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
