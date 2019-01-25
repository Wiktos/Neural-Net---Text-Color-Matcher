package main.java.colormatcher.controller;

import main.java.colormatcher.model.Color;
import main.java.colormatcher.model.NeuralNetLayer;

public interface AI {

    public NeuralNetLayer think(final Color color);

}
