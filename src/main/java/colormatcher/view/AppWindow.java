package main.java.colormatcher.view;

import main.java.colormatcher.controller.AppController;

import javax.swing.*;
import java.awt.*;

/*
    AppWindow is a final class of GUI which collect all panels into one whole.
    This class contains main function of application.

    by Wiktor Łazarski
 */
public class AppWindow extends JFrame {

    private final static String TITLE = "Neural net - Text color matcher";
    private final static int WIDTH = 600;
    private final static int HEIGHT = 400;
    private final InputPanel inputPanel = new InputPanel();
    private final ThinkPanel thinkPanel = new ThinkPanel();

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
            try{
                JFrame window = new AppWindow();
            }
            catch(Exception ex){
                System.err.println(TITLE + " failed to launch");
                System.err.println(ex.getStackTrace());
            }
        });
    }
}
