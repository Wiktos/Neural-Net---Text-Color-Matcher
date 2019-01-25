import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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

        double[] color = new double[3];
        try{
            color[0] = receiveColor(redVal) / 255.0;
            color[1] = receiveColor(greenVal) / 255.0;
            color[2] = receiveColor(blueVal) / 255.0;
        }
        catch (NullPointerException ex) {
            displayErrorMessageBox(ERROR_NON_NUMERICAL_INPUT_MESSAGE, ERROR_DIALOG_BOX_TITLE);
            return;
        }
        catch (IOException ex) {
            displayErrorMessageBox(ERROR_RANGE_MESSAGE, ERROR_DIALOG_BOX_TITLE);
            return;
        }

        String inventedColor = inventColor(color);
        displayInvention(inventedColor, new Color(redVal.get(), greenVal.get(), blueVal.get()));
    }

    private int receiveColor(Optional<Integer> inputColor) throws NullPointerException, IOException {
        if(!inputColor.isPresent()){
            throw new NullPointerException();
        }
        int color = inputColor.get();
        if(color < 0 || color > 255){
            throw new IOException();
        }
        return color;
    }

    private void displayErrorMessageBox(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    private String inventColor(double[] color) {
        double[] output = neuralNet.think(color);
        String inventedColor = NeuralNetResultInterpreter.getInstance().interpret(output);
        return inventedColor;
    }

    private void displayInvention(String invention, Color background) {
        thinkPanel.setInvention(invention);
        thinkPanel.changeBackgroundColor(background);
        if (invention.equals("WHITE")) {
            thinkPanel.changeFontColor(Color.WHITE);
        } else {
            thinkPanel.changeFontColor(Color.BLACK);
        }
    }
}
