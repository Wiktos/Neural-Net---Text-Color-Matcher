package main.java.colormatcher.applogic;

/**
 * Created by Wiktor Łazarski on 25.01.2019.
 */
public class Color {

    public static final int RED_INDEX = 0;
    public static final int GREEN_INDEX = 0;
    public static final int BLUE_INDEX = 0;

    private double[] rgb;

    public Color(double r, double g, double b) {
        if(!checkConstructorInputs(r, g, b)) {
            throw new IllegalArgumentException("Color value not in range [0; 1]");
        }

        rgb = new double[]{r, g, b};
    }

    public Color(java.awt.Color col) {
        rgb = new double[]{col.getRed() / 255.0, col.getGreen() / 255.0, col.getBlue() / 255.0};
    }

    public double red(){
        return rgb[RED_INDEX];
    }

    public double green(){
        return rgb[GREEN_INDEX];
    }

    public double blue(){
        return rgb[BLUE_INDEX];
    }

    public double[] asArray() {
        return rgb;
    }

    private boolean checkConstructorInputs(double r, double g, double b) {
        return checkColorValue(r) && checkColorValue(g) && checkColorValue(b);
    }

    private boolean checkColorValue(double val) {
        return  val >= 0.0 && val <= 1.0;
    }

}
