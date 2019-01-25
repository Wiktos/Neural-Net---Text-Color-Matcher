package main.java.colormatcher.controller;

import java.util.Optional;

/*
    ColorInputable interface provides 'boundary' between Controller and View.
    Panel which implements that interface is responsible for providing input data for AI interface.
    Originally implemented by InputPanel from View module.

    by Wiktor Łazarski
 */
public interface ColorInputable {

    public Optional<Integer> redValue();
    public Optional<Integer> greenValue();
    public Optional<Integer> blueValue();

}
