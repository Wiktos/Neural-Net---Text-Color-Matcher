package main.java.colormatcher.applogic;

/**
 * Created by Wiktor Łazarski on 23.01.2019.
 */
public class NeuralNetResultInterpreter {

    private static final String WHITE = "WHITE";
    private static final String BLACK = "BLACK";

    public static NeuralNetResultInterpreter getInstance() {
        return ourInstance;
    }

    public String interpret(NeuralNetLayer neuralNetOutput) {
        return neuralNetOutput.getNodeValue(0) > neuralNetOutput.getNodeValue(1) ? WHITE : BLACK;
    }

    private static NeuralNetResultInterpreter ourInstance = new NeuralNetResultInterpreter();

    private NeuralNetResultInterpreter() { }
}
