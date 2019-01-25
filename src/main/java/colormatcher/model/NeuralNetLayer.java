package main.java.colormatcher.model;

/**
 * Created by Wiktor Łazarski on 25.01.2019.
 */
public class NeuralNetLayer {

    private double[] nodes;

    public NeuralNetLayer(int nodesNumber) throws IllegalArgumentException {
        if(!checkConstructorInputValue(nodesNumber)){
            throw new IllegalArgumentException("Layer node number less than 0");
        }

        nodes = new double[nodesNumber];
    }

    public int length() {
        return nodes.length;
    }

    public double getNodeValue(int idx) throws IllegalArgumentException {
        if(!checkInputValue(idx)){
            throw new IllegalArgumentException("Layer node index less than 0");
        }

        return nodes[idx];
    }

    public void setNodeValue(int idx, double newValue) throws IllegalArgumentException {
        if(!checkInputValue(idx)){
            throw new IllegalArgumentException("Layer node index less than 0");
        }

        nodes[idx] = newValue;
    }

    private boolean checkConstructorInputValue(int val) {
        return val > 0;
    }

    private boolean checkInputValue(int val) {
        return val >= 0;
    }
}
