package main.java.colormatcher.controller;

import main.java.colormatcher.model.Color;
import main.java.colormatcher.model.NeuralNetLayer;

/*
    AI interface provides 'boundary' between Model and View.
    Originally implemented by NeuralNet from Model module.

    by Wiktor Łazarski
 */
public interface AI {

    public NeuralNetLayer think(final Color color);

}
