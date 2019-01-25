package main.java.colormatcher.view;

import main.java.colormatcher.controller.ColorInputable;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

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
