import java.util.Arrays;

public class NeuralNet {

    /*
    Training data

    Input : Colors are coded using values RGB which are in range [0, 1]
            3 zeros means black
            3 ones means white

    Output : First number indicate white second black
    */
    private final double LEARNING_RATE = 0.1;
    private final double[][] X = new double[][]{{1.0, 1.0, 1.0},
                                            {0.0, 0.0, 0.0}};
    private final double[][] DESIRED_OUTPUT = new double[][]{{0.0, 1.0}, {1.0, 0.0}};
    //synapses
    private double[][] syn0 = new double[3][2];
    private double[][] syn1 = new double[2][2];

    public NeuralNet() {
        fillWeightSyn0();
        fillWeightSyn1();
        for (int i = 0; i < 10000; i++) {
            train(X[0], DESIRED_OUTPUT[0]);
            train(X[1], DESIRED_OUTPUT[1]);
        }
    }

    public double[] think(double[] X) {
        double[] hiddenLayer = computeHiddenLayer(X);
        double[] outputLayer = computeOutputLayer(hiddenLayer);

        return outputLayer;
    }


    private void train(double[] X, double[] d) {
        double[] hiddenLayer = computeHiddenLayer(X);
        double[] outputLayer = computeOutputLayer(hiddenLayer);

        backpropagation(outputLayer, hiddenLayer, X, d);
    }

    private double[] computeHiddenLayer(double[] X){
        //compute hidden layer
        double[] hiddenLayer = new double[2];
        double sum = 0.0;
        for (int i = 0; i < X.length; i++) {
            sum += X[i] * syn0[i][0];
        }
        hiddenLayer[0] = sigmoid(sum);
        sum = 0.0;
        for (int i = 0; i < X.length; i++) {
            sum += X[i] * syn0[i][1];
        }
        hiddenLayer[1] = sigmoid(sum);

        return hiddenLayer;
    }

    private double[] computeOutputLayer(double[] hiddenLayer){
        double[] outputLayer = new double[2];
        double sum = 0.0;
        for(int i = 0; i < hiddenLayer.length; i++){
            sum += hiddenLayer[i] * syn1[i][0];
        }

        outputLayer[0] = sigmoid(sum);
        sum = 0.0;
        for(int i = 0; i < hiddenLayer.length; i++){
            sum += hiddenLayer[i] * syn1[i][1];
        }
        outputLayer[1] = sigmoid(sum);

        return outputLayer;
    }

    private void backpropagation(double[] outputLayer, double[] hiddenLayer, double[] X, double[] desiredOut) {
        double[] outputError = new double[2];
        outputError[0] = desiredOut[0] - outputLayer[0];
        outputError[1] = desiredOut[1] - outputLayer[1];

        double[] outputDelta = new double[]{(outputError[0] * sigmoidDerivative(outputLayer[0])),
                (outputError[1] * sigmoidDerivative(outputLayer[1]))};

        double[][] syn1Delta = new double[2][2];
        for(int i = 0; i < syn1Delta.length; i++) {
            for (int j = 0; j < syn1Delta[i].length; j++) {
                syn1Delta[j][i] = outputDelta[i] * hiddenLayer[j];
            }
        }

        double[] hiddenDelta = new double[]{((outputDelta[0] * syn1[0][0] + outputDelta[1] * syn1[0][1]) * sigmoidDerivative(hiddenLayer[0])),
                                             ((outputDelta[0] * syn1[1][0] + outputDelta[1] * syn1[1][1]) * sigmoidDerivative(hiddenLayer[1]))};

        double[][] syn0Delta = new double[3][2];
        for (int i = 0; i < syn1.length; i++) {
            for (int j = 0; j < syn1[i].length; j++) {
                syn0Delta[i][j] = hiddenDelta[j] * X[i];
            }
        }

        for (int i = 0; i < syn1.length; i++) {
            for (int j = 0; j < syn1[i].length; j++) {
                syn1[i][j] += LEARNING_RATE * syn1Delta[i][j];
            }
        }

        for (int i = 0; i < syn0.length; i++) {
            for (int j = 0; j < syn0[i].length; j++) {
                syn0[i][j] += LEARNING_RATE * syn0Delta[i][j];
            }
        }

        System.out.println(Arrays.toString(outputLayer) + " err : " + Arrays.toString(outputError));
    }

    private void fillWeightSyn0(){
        for(int i = 0; i < syn0.length; i++) {
            for(int j = 0; j < syn0[i].length; j++) {
                syn0[i][j] = 2 * Math.random() - 1;
            }
        }
    }

    private void fillWeightSyn1(){
        for(int i = 0; i < syn1.length; i++) {
            for(int j = 0; j < syn1[i].length; j++) {
                syn1[i][j] = 2 * Math.random() - 1;
            }
        }
    }

    private final double sigmoid(final double x) {
        return 1 / (1 + Math.exp(-x));
    }

    private final double sigmoidDerivative(final double x) {
        return x * (1 - x);
    }

    public static void main(String[] argv){
        NeuralNet net = new NeuralNet();
    }

}
