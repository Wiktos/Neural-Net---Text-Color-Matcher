package main.java.colormatcher.controller;

import java.util.Optional;

public interface ColorInputable {

    public Optional<Integer> redValue();
    public Optional<Integer> greenValue();
    public Optional<Integer> blueValue();

}
