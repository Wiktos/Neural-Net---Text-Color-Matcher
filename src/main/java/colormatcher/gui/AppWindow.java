package main.java.colormatcher.gui;

import main.java.colormatcher.controller.AppController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Wiktor Łazarski on 22.01.2019.
 */
public class AppWindow extends JFrame {

    private final String TITLE = "Neural net - Text color matcher";
    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private InputPanel inputPanel = new InputPanel();
    private ThinkPanel thinkPanel = new ThinkPanel();

    public AppWindow(){
        setDefaultWindowProperties();
        add(inputPanel, BorderLayout.WEST);
        thinkPanel.attachControllerToThinkButton(new AppController(inputPanel, thinkPanel));
        add(thinkPanel, BorderLayout.CENTER);
    }

    private void setDefaultWindowProperties() {
        setSize(new Dimension(WIDTH, HEIGHT));
        setTitle(TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame window = new AppWindow();
        });
    }
}
