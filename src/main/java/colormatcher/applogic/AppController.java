package main.java.colormatcher.applogic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

/**
 * Created by Wiktor Łazarski on 23.01.2019.
 */
public class AppController implements ActionListener {

    private static final String ERROR_DIALOG_BOX_TITLE = "Input error";
    private static final String ERROR_RANGE_MESSAGE = "Make sure all inputs are between [0; 255]";
    private static final String ERROR_NON_NUMERICAL_INPUT_MESSAGE = "Make sure that input is a numerical value";

    private ColorInputable inputPanel;
    private ThinkablePanel thinkPanel;
    private NeuralNet neuralNet = new NeuralNet();

    public AppController(ColorInputable inputPanel, ThinkablePanel thinkPanel) {
        this.inputPanel = inputPanel;
        this.thinkPanel = thinkPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Optional<Integer> redVal = inputPanel.redValue();
        Optional<Integer> greenVal = inputPanel.greenValue();
        Optional<Integer> blueVal = inputPanel.blueValue();

        Color color;
        try{
            color = new Color(receiveColor(redVal) / 255.0, receiveColor(greenVal) / 255.0, receiveColor(blueVal) / 255.0);
        }
        catch (NullPointerException ex) {
            displayErrorMessageBox(ERROR_NON_NUMERICAL_INPUT_MESSAGE, ERROR_DIALOG_BOX_TITLE);
            return;
        }
        catch (IllegalArgumentException ex) {
            displayErrorMessageBox(ERROR_RANGE_MESSAGE, ERROR_DIALOG_BOX_TITLE);
            return;
        }

        String inventedColor = inventColor(color);
        displayInvention(inventedColor, new java.awt.Color(redVal.get(), greenVal.get(), blueVal.get()));
    }

    private int receiveColor(Optional<Integer> inputColor) throws NullPointerException, IllegalArgumentException {
        if(!inputColor.isPresent()){
            throw new NullPointerException();
        }
        int color = inputColor.get();
        if(color < 0 || color > 255){
            throw new IllegalArgumentException();
        }
        return color;
    }

    private void displayErrorMessageBox(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    private String inventColor(Color color) {
        NeuralNetLayer output = neuralNet.think(color);
        String inventedColor = NeuralNetResultInterpreter.getInstance().interpret(output);
        return inventedColor;
    }

    private void displayInvention(String invention, java.awt.Color background) {
        thinkPanel.setInvention(invention);
        thinkPanel.changeBackgroundColor(background);
        if (invention.equals(NeuralNetResultInterpreter.WHITE)) {
            thinkPanel.changeFontColor(java.awt.Color.WHITE);
        } else {
            thinkPanel.changeFontColor(java.awt.Color.BLACK);
        }
    }
}
