package main.java.colormatcher.model;

public class NeuralNetResultInterpreter {

    public static final String WHITE = "WHITE";
    public static final String BLACK = "BLACK";

    public static NeuralNetResultInterpreter getInstance() {
        return ourInstance;
    }

    public String interpret(NeuralNetLayer neuralNetOutput) {
        return neuralNetOutput.getNodeValue(0) > neuralNetOutput.getNodeValue(1) ? WHITE : BLACK;
    }

    private static NeuralNetResultInterpreter ourInstance = new NeuralNetResultInterpreter();

    private NeuralNetResultInterpreter() { }
}
