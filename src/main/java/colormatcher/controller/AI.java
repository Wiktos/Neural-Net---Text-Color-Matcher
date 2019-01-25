package main.java.colormatcher.controller;

import main.java.colormatcher.model.Color;
import main.java.colormatcher.model.NeuralNetLayer;

/**
 * Created by Wiktor Łazarski on 25.01.2019.
 */
public interface AI {

    public NeuralNetLayer think(final Color color);

}
