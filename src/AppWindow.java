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
    private PredictPanel predictPanel = new PredictPanel();

    public AppWindow(){
        setDefaultWindowProperties();
        add(inputPanel, BorderLayout.WEST);
        predictPanel.attachControllerToPredictButton(new AppController(inputPanel, predictPanel));
        add(predictPanel, BorderLayout.CENTER);
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
