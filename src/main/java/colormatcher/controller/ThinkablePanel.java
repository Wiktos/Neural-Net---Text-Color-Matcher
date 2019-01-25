package main.java.colormatcher.controller;

/*
    ThinkablePanel interface provides 'boundary' between Controller and View.
    Panel which implements that interface is responsible for displaying results provided by AI interface.
    Originally implemented by ThinkPanel from View module.

    by Wiktor Łazarski
 */
public interface ThinkablePanel {

    public void setInvention(final String invention);
    public void changeBackgroundColor(final java.awt.Color color);
    public void changeFontColor(final java.awt.Color color);

}
