package main.java.colormatcher.model;

/*
    NeuralNetLayer is a class which represent NeuralNet layer.
    The only one exception is input layer which is represented by Color class.

    by Wiktor Łazarski
 */
public class NeuralNetLayer {

    private double[] nodes;

    public NeuralNetLayer(final int nodesNumber) throws IllegalArgumentException {
        if(!checkConstructorInputValue(nodesNumber)){
            throw new IllegalArgumentException("Layer node number less than 0");
        }

        nodes = new double[nodesNumber];
    }

    public int length() {
        return nodes.length;
    }

    public double getNodeValue(final int idx) throws IllegalArgumentException {
        if(!checkInputValue(idx)){
            throw new IllegalArgumentException("Layer node index less than 0");
        }

        return nodes[idx];
    }

    public void setNodeValue(final int idx, double newValue) throws IllegalArgumentException {
        if(!checkInputValue(idx)){
            throw new IllegalArgumentException("Layer node index less than 0");
        }

        nodes[idx] = newValue;
    }

    private boolean checkConstructorInputValue(final int val) {
        return val > 0;
    }

    private boolean checkInputValue(final int val) {
        return val >= 0;
    }
}
