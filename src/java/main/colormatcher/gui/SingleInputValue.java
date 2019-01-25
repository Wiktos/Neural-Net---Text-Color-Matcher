package java.main.colormatcher.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Wiktor Łazarski on 23.01.2019.
 */
public class SingleInputValue extends JPanel{

    private JLabel description;
    private JTextField inputTextField;

    public SingleInputValue(String description) {
        setLayout(new GridLayout(1, 2));
        setLabelProperties(description);
        setTextFieldProperties();
        addComponentToGrid(this.description);
        addComponentToGrid(inputTextField);
    }

    public Integer getData() {
        try {
            int retVal = Integer.parseInt(inputTextField.getText().trim());
            return retVal;
        }
        catch(NumberFormatException ex){
            return null;
        }
    }

    private void setLabelProperties(String description) {
        this.description = new JLabel(description);
        this.description.setHorizontalAlignment(SwingConstants.CENTER);
        this.description.setFont(new Font("TimesRoman", Font.PLAIN + Font.BOLD, 20));
    }

    private void setTextFieldProperties() {
        inputTextField = new JTextField();
        inputTextField.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        inputTextField.setColumns(5);
    }

    private void addComponentToGrid(JComponent component) {
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
        JPanel panel = new JPanel(layout);
        panel.add(component);
        add(panel);
    }
}
