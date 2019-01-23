import javax.swing.*;
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

    private InputPanel inputPanel;
    private PredictPanel predictPanel;
    private NeuralNet neuralNet = new NeuralNet();

    public AppController(InputPanel inputPanel, PredictPanel predictPanel) {
        this.inputPanel = inputPanel;
        this.predictPanel = predictPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Optional<Integer> redVal = inputPanel.redValue();
        Optional<Integer> greenVal = inputPanel.greenValue();
        Optional<Integer> blueVal = inputPanel.blueValue();

        double[] colors = new double[3];
        try{
            colors[0] = receiveColor(redVal);
            colors[1] = receiveColor(greenVal);
            colors[2] = receiveColor(blueVal);
        }
        catch (NullPointerException ex) {
            displayErrorMessageBox(ERROR_NON_NUMERICAL_INPUT_MESSAGE, ERROR_DIALOG_BOX_TITLE);
            return;
        }
        catch (IOException ex) {
            displayErrorMessageBox(ERROR_RANGE_MESSAGE, ERROR_DIALOG_BOX_TITLE);
            return;
        }

        double[] output = neuralNet.think(colors);
        String predictedColor = NeuralNetResultInterpreter.getInstance().interpret(output);
        predictPanel.setPrediction(predictedColor);
    }

    private double receiveColor(Optional<Integer> inputColor) throws NullPointerException, IOException {
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
}
