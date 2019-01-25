package java.main.colormatcher.gui;

import javax.swing.*;
import java.awt.*;
import java.main.colormatcher.applogic.ColorInputable;
import java.util.Optional;

/**
 * Created by Wiktor Łazarski on 23.01.2019.
 */
public class InputPanel extends JPanel implements ColorInputable {

    private SingleInputValue red = new SingleInputValue("RED VALUE");
    private SingleInputValue green = new SingleInputValue("GREEN VALUE");
    private SingleInputValue blue = new SingleInputValue("BLUE VALUE");

    public InputPanel() {
        setLayout(new GridLayout(3, 1));
        add(red);
        add(green);
        add(blue);
    }

    public Optional<Integer> redValue() {
        Optional<Integer> retVal = Optional.ofNullable(red.getData());
        return retVal;
    }

    public Optional<Integer> greenValue() {
        Optional<Integer> retVal = Optional.ofNullable(green.getData());
        return retVal;
    }

    public Optional<Integer> blueValue() {
        Optional<Integer> retVal = Optional.ofNullable(blue.getData());
        return retVal;
    }
}
