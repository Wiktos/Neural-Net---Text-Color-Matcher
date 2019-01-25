package main.java.colormatcher.model;

/*
    Synapse class represents connection between layers in NeuralNet.

    by Wiktor Łazarski
 */
public class Synapse {

    private double[] weights;
    private final int row;
    private final int col;

    public Synapse(int row, int col) throws IllegalArgumentException {
        if(!checkInputsValue(row, col)){
            throw new IllegalArgumentException("Synapse dimension param cannot be less than zero");
        }

        weights = new double[row * col];
        this.row = row;
        this.col = col;

        fillWeightsWithRandomValues();
    }

    public double getWeight(int x, int y) throws IllegalArgumentException {
        if(!isWeightExisting(x, y)){
            throw new IllegalArgumentException();
        }
        return weights[x * col +  y];
    }

    public void setWeight(int x, int y, double newValue) throws IllegalArgumentException {
        if(!isWeightExisting(x, y)){
            throw new IllegalArgumentException();
        }
        weights[x * col +  y] = newValue;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    private boolean checkInputsValue(int width, int height) {
        return isGreaterThanZero(width) && isGreaterThanZero(height);
    }

    private void fillWeightsWithRandomValues(){
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                setWeight(i, j, 2 * Math.random() - 1);
            }
        }
    }

    private boolean isWeightExisting(int x, int y) {
        return x < row || y < col;
    }

    private boolean isGreaterThanZero(int val) {
        return val > 0;
    }
}
