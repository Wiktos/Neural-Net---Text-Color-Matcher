package main.java.colormatcher.view;

import main.java.colormatcher.controller.ColorInputable;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

/*
    InputPanel is a class responsible for collecting the input color data from the user, which will be used as input layer in NeuralNet.

    by Wiktor Łazarski
 */
public class InputPanel extends JPanel implements ColorInputable {

    private final SingleInputValue red = new SingleInputValue("RED VALUE");
    private final SingleInputValue green = new SingleInputValue("GREEN VALUE");
    private final SingleInputValue blue = new SingleInputValue("BLUE VALUE");

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
